<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\DAO\MatriculaDAO;
    use App\Models\Alumno;
    use App\Contracts\AlumnoContract;
    use App\Contracts\MatriculaContract;
    use App\Contracts\Asignatura_MatriculaContract;
    use Exception;
    use PDO;

    class AlumnoDAO implements ICrud{
        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($alumno){
            $res = null;

            $tablename = AlumnoContract::TABLE_NAME;
            $colid = AlumnoContract::COL_ID;
            $colnombre = AlumnoContract::COL_NOMBRE;
            $colap = AlumnoContract::COL_APELLIDOS;
            $colfecha = AlumnoContract::COL_FECHA_NAC;

            $sql = "INSERT INTO $tablename ($colid, $colnombre, $colap, $colfecha)
            VALUES(:id, :nombre, :apellidos, :fecha)";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $alumno->getDni(),
                        ':nombre' => $alumno->getNombre(),
                        ':apellidos' => $alumno->getApellidos(),
                        ':fecha' => $alumno->getFechaNac()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();



                if($filasAfectadas > 0){
                    $res = $alumno;
                    $id = $this->myPDO->lastInsertId();
                    $res->setDni($id);
                }

                //echo "<br>afectadas: ".$filasAfectadas;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
            }
            $stmt = null;

            return $res;
        }

        public function update($alumno){
            $error = false;

            $tablename = AlumnoContract::TABLE_NAME;
            $colid = AlumnoContract::COL_ID;
            $colnombre = AlumnoContract::COL_NOMBRE;
            $coleap = AlumnoContract::COL_APELLIDOS;
            $colfecha = AlumnoContract::COL_FECHA_NAC;


            $sql = "UPDATE $tablename SET $colnombre = :nombre,
            $coleap = :apellidos, $colfecha = :fecha WHERE
            $colid = :dni";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':nombre' => $alumno->getNombre(),
                        ':apellidos' => $alumno->getApellidos(),
                        ':fecha' => $alumno->getFechaNac(),
                        ':dni' => $alumno->getDni()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $this->myPDO->rollback();
                $error = true;
            }
            return $error;
        }

        public function findAll(){
            $stmt = $this->myPDO->prepare("SELECT * FROM ".AlumnoContract::TABLE_NAME);
            $stmt->setFetchMode(PDO::FETCH_ASSOC); //devuelve array asociativo
            $stmt->execute(); // Ejecutamos la sentencia
            $alumnos = [];

            while ($row = $stmt->fetch()){
                $a = new Alumno();
                $a->setDni($row[AlumnoContract::COL_ID]);
                $a->setNombre($row[AlumnoContract::COL_NOMBRE]);
                $a->setApellidos($row[AlumnoContract::COL_APELLIDOS]);
                $a->setFechaNac($row[AlumnoContract::COL_FECHA_NAC]);

                $alumnos[] = $a;
            }
            return $alumnos;
        }

        public function findById($id){
            $a = null;

            $tablename = AlumnoContract::TABLE_NAME;
            $colid = AlumnoContract::COL_ID;

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

                //echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

                if($row = $stmt->fetch()){
                    $a = new Alumno();
                    $a->setDni($row[AlumnoContract::COL_ID]);
                    $a->setNombre($row[AlumnoContract::COL_NOMBRE]);
                    $a->setApellidos($row[AlumnoContract::COL_APELLIDOS]);
                    $a->setFechaNac($row[AlumnoContract::COL_FECHA_NAC]);
                }
                return $a;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                $this->myPDO->rollback();
            }
            return $a;
        }

        public function delete($dni){
            $error = false;

            $tablename = AlumnoContract::TABLE_NAME;
            $colid = AlumnoContract::COL_ID;

            $sqlAlum = "DELETE FROM $tablename WHERE $colid = :id";

            echo "1";
            try{

                $stmt = $this->myPDO->prepare($sqlAlum);
                echo "2";
                $matriculaDAO = new MatriculaDAO($this->myPDO);

                $matr = $matriculaDAO->findByDni($dni);
                echo "3";
                var_dump($matr);
                if($matr != null){
                    echo "4";
                    foreach ($matr as $key => $value) {
                        echo "5";
                        $matriculaDAO->delete($value->getIdmatricula());
                        echo "6";
                    }
                }
                
                echo "7";

                //si filasAfectadas > 0 => hubo éxito consulta
               
                $filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;


            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                //$this->myPDO->rollback();
                $error = true;
            }
            return $error;
        }
    }
?>
