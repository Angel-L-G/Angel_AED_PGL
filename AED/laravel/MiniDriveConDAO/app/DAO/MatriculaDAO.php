<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\DAO\AlumnoDAO;
    use App\Models\Matricula;
    use App\Contracts\MatriculaContract;
    use App\Contracts\Asignatura_MatriculaContract;
    use Exception;
    use PDO;

    class MatriculaDAO implements ICrud{
        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($matricula){
            $a = null;
            echo "SAAAAVVVEEE::::: ";
            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;
            $coldni = MatriculaContract::COL_DNI;
            $colyear = MatriculaContract::COL_YEAR;
            echo "1";
            $tablenameSecundary = Asignatura_MatriculaContract::TABLE_NAME;
            $colIdMatr = Asignatura_MatriculaContract::COL_ID_MATRICULA;
            $colIdAsig = Asignatura_MatriculaContract::COL_ID_ASIGNATURA;
            echo "2";
            $sql = "INSERT INTO $tablename ($colid, $coldni, $colyear)
            VALUES(:id, :dni, :year)";
            echo "3";
            $sqlSecundary = "INSERT INTO $tablenameSecundary ($colIdMatr, $colIdAsig)
            VALUES(:idMatr,:idAsig)";
            echo "4";
            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);
                echo "5";
                $stmt->execute(
                    [
                        ':id' => $matricula->getIdmatricula(),
                        ':dni' => $matricula->getAlumno()->getDni(),
                        ':year' => $matricula->getYear()
                    ]
                );
                echo "6";
                //si filasAfectadas > 0 => hubo éxito consulta
                //$filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;

                $asignaturas = $matricula->getAsignaturas();
                $stmt = $this->myPDO->prepare($sqlSecundary);
                echo "7";
                foreach ($asignaturas as $key => $value) {
                    echo "8";
                    $stmt->execute(
                        [
                            ':idMatr' => $matricula->getIdmatricula(),
                            ':idAsig' => $value->getId()
                        ]
                    );
                }
                
                echo "9";
                while($row = $stmt->fetch()){
                    $a = new Matricula();
                    echo "-10";
                    $alumnoDAO = new AlumnoDAO($this->myPDO);
                    $alum = $alumnoDAO->findById($row[MatriculaContract::COL_DNI]);
                    $a->setAlumno($alum);
                    echo "-11";
                    //$a->setAsignaturas($row[MatriculaContract::COL]);
                    echo "-12";
                    $a->setYear($row[MatriculaContract::COL_YEAR]);
                    $a->setIdmatricula($row[MatriculaContract::COL_ID]);
                }
                echo "-13";

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
            }
            $stmt = null;

            return $a;
        }

        public function update($matricula){
            $error = false;

            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;
            $coldni = MatriculaContract::COL_DNI;
            $colyear = MatriculaContract::COL_YEAR;

            $sql = "UPDATE $tablename SET $coldni = :dni,
            $colyear = :year WHERE $colid = :id";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':dni' => $matricula->getAlumno()->getDni(),
                        ':year' => $matricula->getYear(),
                        ':id' => $matricula->getIdmatricula()
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
            $asignaturas = [];

            while ($row = $stmt->fetch()){
                $a = new Matricula();
                $alumnoDAO = new AlumnoDAO($this->myPDO);
                $alum = $alumnoDAO->findById($row[MatriculaContract::COL_DNI]);
                $a->setAlumno($alum);
                $a->setYear($row[MatriculaContract::COL_YEAR]);
                $a->setIdmatricula($row[MatriculaContract::COL_ID]);
                $asignaturas[] = $a;
            }

            return $asignaturas;
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
                //$filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

                if($row = $stmt->fetch()){
                    $a = new Matricula();
                    
                    $alumnoDAO = new AlumnoDAO($this->myPDO);
                    $alum = $alumnoDAO->findById($row[MatriculaContract::COL_DNI]);
                    $a->setAlumno($alum);
                    $a->setIdmatricula($row[MatriculaContract::COL_ID]);
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

            $tablenameInter = Asignatura_MatriculaContract::TABLE_NAME;
            $colIdInter = Asignatura_MatriculaContract::COL_ID_MATRICULA;

            $sqlInter = "DELETE FROM $tablenameInter WHERE $colIdInter = :idMatr";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sqlInter);
                
                $stmt->execute(
                    [
                        ':idMatr' => $id
                    ]
                );

                $stmt = $this->myPDO->prepare($sql);
                $stmt->execute(
                    [
                        ':id' => $id
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                //$filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $this->myPDO->rollback();
                $error = true;
            }
            return $error;
        }

        public function findByDni($dni){
            $res = null;

            $tablename = MatriculaContract::TABLE_NAME;
            $colDni = MatriculaContract::COL_DNI;

            $sql = "SELECT * FROM $tablename WHERE $colDni = :dni";
            try{
                
                //$this->myPDO->beginTransaction();

                $stmt = $this->myPDO->prepare($sql);
                
                $stmt->execute(
                    [
                        ':dni' => $dni
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                //$filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;


                $res = [];
                while ($row = $stmt->fetch()){
                    $a = new Matricula();

                    $alumnoDAO = new AlumnoDAO($this->myPDO);
                    $alum = $alumnoDAO->findById($row[MatriculaContract::COL_DNI]);
                    $a->setAlumno($alum);
                    $a->setIdmatricula($row[MatriculaContract::COL_ID]); 
                    $a->setYear($row[MatriculaContract::COL_YEAR]);

                    $res[] = $a;
                }

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                //$this->myPDO->rollback();
            }
            return $res;
        }

    }

?>
