<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\Models\Asignatura;
    use App\Contracts\AsignaturaContract;
    use Exception;
    use PDO;

    class AsignaturaDAO implements ICrud{
        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($asignatura){
            $error = false;

            $tablename = AsignaturaContract::TABLE_NAME;
            $colid = AsignaturaContract::COL_ID;
            $colnombre = AsignaturaContract::COL_NOMBRE;
            $colcurso = AsignaturaContract::COL_CURSO;

            $sql = "INSERT INTO $tablename ($colid, $colnombre, $colcurso)
            VALUES(:id, :nombre, :curso)";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $asignatura->getId(),
                        ':nombre' => $asignatura->getNombre(),
                        ':curso' => $asignatura->getCurso()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                echo "<br>afectadas: ".$filasAfectadas;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $error = true;
            }
            $stmt = null;

            return $error;
        }

        public function update($asignatura){
            $error = false;

            $tablename = AsignaturaContract::TABLE_NAME;
            $colid = AsignaturaContract::COL_ID;
            $colnombre = AsignaturaContract::COL_NOMBRE;
            $colcurso = AsignaturaContract::COL_CURSO;

            $sql = "UPDATE $tablename SET $colnombre = :nombre,
            $colcurso = :curso WHERE $colid = $asignatura->getId()";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':nombre' => $asignatura->getNombre(),
                        ':curso' => $asignatura->getCurso()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $this->myPDO->rollback();
                $error = false;
            }
            return $error;
        }

        public function findAll(){
            $stmt = $this->myPDO->prepare("SELECT * FROM ".AsignaturaContract::TABLE_NAME);
            $stmt->setFetchMode(PDO::FETCH_ASSOC); //devuelve array asociativo
            $stmt->execute(); // Ejecutamos la sentencia
            $asignatura = [];

            while ($row = $stmt->fetch()){
                $a = new Asignatura();
                $a->setId($row[AsignaturaContract::COL_ID]);
                $a->setNombre($row[AsignaturaContract::COL_NOMBRE]);
                $a->setCurso($row[AsignaturaContract::COL_CURSO]);

                $asignatura[] = $a;
            }
            return $asignatura;
        }

        public function findById($id){
            $a = null;

            $tablename = AsignaturaContract::TABLE_NAME;
            $colid = AsignaturaContract::COL_ID;

            $sql = "SELECT * FROM $tablename WHERE $colid = :id";

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

                if($row = $stmt->fetch()){
                    $a = new Asignatura();
                    $a->setId($row[AsignaturaContract::COL_ID]);
                    $a->setNombre($row[AsignaturaContract::COL_NOMBRE]);
                    $a->setCurso($row[AsignaturaContract::COL_CURSO]);
                }
                return $a;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $this->myPDO->rollback();
            }
            return $a;
        }

        public function delete($id){
            $error = false;

            $tablename = AsignaturaContract::TABLE_NAME;
            $colid = AsignaturaContract::COL_ID;

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
                $error = true;
            }
            return $error;
        }
    }

?>
