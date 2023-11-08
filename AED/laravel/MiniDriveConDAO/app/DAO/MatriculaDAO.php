<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\DAO\AlumnoDAO;
    use App\Models\Matricula;
    use App\Contracts\MatriculaContract;
    use App\Contracts\Asignatura_MatriculaContract;
    use App\Contracts\AsignaturaContract;
    use App\DAO\AsignaturaDAO;
use App\Http\Controllers\AsignaturaController;
use App\Models\Asignatura;
use Exception;
    use PDO;

    class MatriculaDAO implements ICrud{
        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($matricula){
            $m = null;

            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;
            $coldni = MatriculaContract::COL_DNI;
            $colyear = MatriculaContract::COL_YEAR;

            $tablenameSecundary = Asignatura_MatriculaContract::TABLE_NAME;
            $colIdMatr = Asignatura_MatriculaContract::COL_ID_MATRICULA;
            $colIdAsig = Asignatura_MatriculaContract::COL_ID_ASIGNATURA;

            $sql = "INSERT INTO $tablename ($colid, $coldni, $colyear)
            VALUES(:id, :dni, :year)";

            $sqlSecundary = "INSERT INTO $tablenameSecundary ($colIdMatr, $colIdAsig)
            VALUES(:idMatr,:idAsig)";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $matricula->getIdmatricula(),
                        ':dni' => $matricula->getAlumno()->getDni(),
                        ':year' => $matricula->getYear()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;

                $asignaturas = $matricula->getAsignaturas();
                $stmt = $this->myPDO->prepare($sqlSecundary);

                foreach ($asignaturas as $key => $value) {

                    $stmt->execute(
                        [
                            ':idMatr' => $matricula->getIdmatricula(),
                            ':idAsig' => $value->getId()
                        ]
                    );
                }
                
                $this->myPDO->commit();
                $m = $matricula;
                $id = $this->myPDO->lastInsertId();
                $m->setIdmatricula($id);

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                echo "Error: " . $ex->getMessage();
                $this->myPDO->rollback();
            }
            $stmt = null;

            return $m;
        }

        public function update($matricula){
            $error = false;

            $tablename = MatriculaContract::TABLE_NAME;
            $colid = MatriculaContract::COL_ID;
            $coldni = MatriculaContract::COL_DNI;
            $colyear = MatriculaContract::COL_YEAR;

            $tablenameSecundary = Asignatura_MatriculaContract::TABLE_NAME;
            $colIdMatr = Asignatura_MatriculaContract::COL_ID_MATRICULA;
            $colIdAsig = Asignatura_MatriculaContract::COL_ID_ASIGNATURA;

            $sql = "UPDATE $tablename SET $coldni = :dni,
            $colyear = :year WHERE $colid = :id";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare(
                    "Delete from " .
                        Asignatura_MatriculaContract::TABLE_NAME . 
                    " where " . 
                        Asignatura_MatriculaContract::COL_ID_MATRICULA . 
                        " = :id"
                );

                $asignaturas = $matricula->getAsignaturas();
                foreach ($asignaturas as $key => $value) {
                    $stmt->execute([
                        ':id' => $matricula->getIdmatricula()
                    ]);
                }

                $sqlSecundary = "INSERT INTO $tablenameSecundary ($colIdMatr, $colIdAsig)
                VALUES(:idMatr,:idAsig)";
                $stmt = $this->myPDO->prepare($sqlSecundary);
                foreach ($asignaturas as $key => $value) {
                    $stmt->execute(
                        [
                            ':idMatr' => $matricula->getIdmatricula(),
                            ':idAsig' => $value->getId()
                        ]
                    );
                }
                
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

                //echo "<br>afectadas: ".$filasAfectadas;

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
            $matriculas = [];

            while ($row = $stmt->fetch()){
                $m = new Matricula();
                $alumnoDAO = new AlumnoDAO($this->myPDO);
                $alum = $alumnoDAO->findById($row[MatriculaContract::COL_DNI]);
                $m->setAlumno($alum);
                $m->setYear($row[MatriculaContract::COL_YEAR]);
                $m->setIdmatricula($row[MatriculaContract::COL_ID]);

                $asignaturas = [];
                $sql = "select " .
                    AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_ID . ", " .
                    AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_NOMBRE . ", " .
                    AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_CURSO .
                " from " .
                    Asignatura_MatriculaContract::TABLE_NAME . 
                " join " .
                    AsignaturaContract::TABLE_NAME .
                " on " .
                    AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_ID . " = " . 
                    Asignatura_MatriculaContract::TABLE_NAME . "." . Asignatura_MatriculaContract::COL_ID_ASIGNATURA .
                " where " . 
                    Asignatura_MatriculaContract::TABLE_NAME . "." . Asignatura_MatriculaContract::COL_ID_MATRICULA . " = :id;";


                $stmtSecundary = $this->myPDO->prepare($sql);
                $stmtSecundary->setFetchMode(PDO::FETCH_ASSOC);

                $stmtSecundary->execute([
                    ':id' => $m->getIdmatricula()
                ]);

                while ($row2 = $stmtSecundary->fetch()){
                    $asig = new Asignatura();
                    $asig->setNombre($row2[AsignaturaContract::COL_NOMBRE]);
                    $asig->setCurso($row2[AsignaturaContract::COL_CURSO]);
                    $asig->setId($row2[AsignaturaContract::COL_ID]);
                    $asignaturas[] = $asig;
                }

                $m->setAsignaturas($asignaturas);
                $matriculas[] = $m;
            }

            return $matriculas;
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

                    $asignaturas = [];
                    $sql = "select " .
                        AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_ID . ", " .
                        AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_NOMBRE . ", " .
                        AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_CURSO .
                    " from " .
                        Asignatura_MatriculaContract::TABLE_NAME . 
                    " join " .
                        AsignaturaContract::TABLE_NAME .
                    " on " .
                        AsignaturaContract::TABLE_NAME . "." . AsignaturaContract::COL_ID . " = " . 
                        Asignatura_MatriculaContract::TABLE_NAME . "." . Asignatura_MatriculaContract::COL_ID_ASIGNATURA .
                    " where " . 
                        Asignatura_MatriculaContract::TABLE_NAME . "." . Asignatura_MatriculaContract::COL_ID_MATRICULA . " = :id;";


                    $stmtSecundary = $this->myPDO->prepare($sql);
                    $stmtSecundary->setFetchMode(PDO::FETCH_ASSOC);

                    $stmtSecundary->execute([
                        ':id' => $a->getIdmatricula()
                    ]);

                    while ($row2 = $stmtSecundary->fetch()){
                        $asig = new Asignatura();
                        $asig->setNombre($row2[AsignaturaContract::COL_NOMBRE]);
                        $asig->setCurso($row2[AsignaturaContract::COL_CURSO]);
                        $asig->setId($row2[AsignaturaContract::COL_ID]);
                        $asignaturas[] = $asig;
                    }

                    $a->setAsignaturas($asignaturas);
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
