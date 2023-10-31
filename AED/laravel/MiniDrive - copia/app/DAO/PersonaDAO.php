<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\Models\Persona;
    use App\Contracts\PersonaContract;
    use Exception;
    use Faker\Core\Number;
    use PDO;

    class PersonaDAO implements ICrud{
        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($dao){
            $tablename = PersonaContract::TABLE_NAME;
            $colid = PersonaContract::COL_ID;
            $coledad = PersonaContract::COL_EDAD;
            $colnombre = PersonaContract::COL_NOMBRE;

            $sql = "INSERT INTO $tablename ($colid, $colnombre, $coledad)
            VALUES(:id,:nombre, :edad)";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $dao->id,
                        ':nombre' => $dao->nombre,
                        ':edad' => $dao->edad
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                echo "<br>afectadas: ".$filasAfectadas;

                $stmt->execute([
                    ':id' => null,
                    ':nombre' => "ani".rand(2000,3000),
                    ":edad" => rand(18,100)
                ]);

                //obtenemos el id generado con:
                $idgenerado = $this->myPDO->lastInsertId();

                $filasAfectadas = $stmt->rowCount();

                echo "<br>afectadas 2: ".$filasAfectadas;

                //forzamos un rollback aleatorio para ver que deshace los cambios
                if( $idgenerado > rand(0,300) ){
                    echo "aleatorio pequeño. Forzamos un rollback";
                    $this->myPDO->rollback();
                }else{
                    $this->myPDO->commit();
                }
            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
            }
            $stmt = null;

        }

        public function update($dao){
            $tablename = PersonaContract::TABLE_NAME;
            $colid = PersonaContract::COL_ID;
            $coledad = PersonaContract::COL_EDAD;
            $colnombre = PersonaContract::COL_NOMBRE;

            $sql = "UPDATE $tablename SET $colnombre = :nombre,
            $coledad = :edad WHERE $colid = $dao->id";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':nombre' => $dao->nombre,
                        ':edad' => $dao->edad
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $this->myPDO->rollback();
            }
        }

        public function delete($id){
            $tablename = PersonaContract::TABLE_NAME;
            $colid = PersonaContract::COL_ID;
            $coledad = PersonaContract::COL_EDAD;
            $colnombre = PersonaContract::COL_NOMBRE;

            $sql = "DELETE FROM $tablename WHERE $colid = :id";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $id
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $this->myPDO->rollback();
            }
        }

        public function findById($id){

        }

        public function findAll(){
            $stmt = $this->myPDO->prepare("SELECT * FROM ".PersonaContract::TABLE_NAME);
            $stmt->setFetchMode(PDO::FETCH_ASSOC); //devuelve array asociativo
            $stmt->execute(); // Ejecutamos la sentencia
            $personas = [];

            while ($row = $stmt->fetch()){
                $p = new Persona();
                $p->id = $row["id"];
                $p->setNombre($row["nombre"])
                ->setEdad($row["edad"]);

                $personas[] = $p;
            }
            return $personas;
        }
    }
