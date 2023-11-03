<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\Models\Matricula;
    use App\Contracts\MatriculaContract;
    use Exception;
    use PDO;

    class MatriculaDAO implements ICrud{
        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($matricula){
            $error = false;

            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;
            $coldni = MatriculaContract::COL_DNI;
            $colyear = MatriculaContract::COL_YEAR;

            $sql = "INSERT INTO $tablename ($colid, $coldni, $colyear)
            VALUES(:id, :nombre, :curso)";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $matricula->getIdmatricula(),
                        ':dni' => $matricula->getDni(),
                        ':year' => $matricula->getYear()
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

        public function update($matricula){
            $error = false;

            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;
            $coldni = MatriculaContract::COL_DNI;
            $colyear = MatriculaContract::COL_YEAR;

            $sql = "UPDATE $tablename SET $coldni = :dni,
            $colyear = :year WHERE $colid = $matricula->getIdmatricula()";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':dni' => $matricula->getDni(),
                        ':year' => $matricula->getYear()
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
            $stmt = $this->myPDO->prepare("SELECT * FROM ".MatriculaContract::TABLE_NAME);
            $stmt->setFetchMode(PDO::FETCH_ASSOC); //devuelve array asociativo
            $stmt->execute(); // Ejecutamos la sentencia
            $asignatura = [];

            while ($row = $stmt->fetch()){
                $a = new Matricula();
                $a->setIdmatricula($row[MatriculaContract::COL_ID]);
                $a->setDni($row[MatriculaContract::COL_DNI]);
                $a->setYear($row[MatriculaContract::COL_YEAR]);

                $asignatura[] = $a;
            }
            return $asignatura;
        }

        public function findById($id){
            $a = null;

            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;

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
                    $a = new Matricula();
                    $a->setIdmatricula($row[MatriculaContract::COL_ID]);
                    $a->setDni($row[MatriculaContract::COL_DNI]);
                    $a->setYear($row[MatriculaContract::COL_YEAR]);
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

            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;

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
