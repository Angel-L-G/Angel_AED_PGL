<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\Models\Empleado;
    use App\Contracts\EmpleadoContract;
    use Exception;
    use PDO;

    class EmpleadoDAO implements ICrud{

        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($dao){
            $res = null;

            $tablename = EmpleadoContract::TABLE_NAME;
            $colid = EmpleadoContract::COL_ID;
            $colnombre = EmpleadoContract::COL_NOMBRE;
            $colap = EmpleadoContract::COL_APELLIDOS;
            $colfecha = EmpleadoContract::COL_FECHA_CONTRATO;
            $coljefe = EmpleadoContract::COL_JEFE;
            $colnumero = EmpleadoContract::COL_NUMERO;
            $colcalle = EmpleadoContract::COL_CALLE;
            $colmunicipio = EmpleadoContract::COL_MUNICIPIO;

            $sql = "INSERT INTO $tablename (
                    $colid, $colnombre, $colap, $colfecha,
                    $coljefe,$colnumero,$colcalle,$colmunicipio
                ) VALUES(
                    :id, :nombre, :apellidos, :fecha,
                    :jefe, :numero, :calle, :municipio
                )";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $dao->getId(),
                        ':nombre' => $dao->getNombre(),
                        ':apellidos' => $dao->getApellidos(),
                        ':fecha' => $dao->getFechaContrato(),
                        ':jefe' => $dao->getJefe()->getId(),
                        ':numero' => $dao->getNumero(),
                        ':calle' => $dao->getCalle(),
                        ':municipio' => $dao->getMunicipio()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                if($filasAfectadas > 0){
                    $res = $dao;
                }

                $this->myPDO->commit();
                //echo "<br>afectadas: ".$filasAfectadas;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                echo "Error: " . $ex->getMessage();
            }
            $stmt = null;

            return $res;
        }

        public function update($dao){
            $ok = true;

            $tablename = EmpleadoContract::TABLE_NAME;
            $colid = EmpleadoContract::COL_ID;
            $colnombre = EmpleadoContract::COL_NOMBRE;
            $colap = EmpleadoContract::COL_APELLIDOS;
            $colfecha = EmpleadoContract::COL_FECHA_CONTRATO;
            $coljefe = EmpleadoContract::COL_JEFE;
            $colnumero = EmpleadoContract::COL_NUMERO;
            $colcalle = EmpleadoContract::COL_CALLE;
            $colmunicipio = EmpleadoContract::COL_MUNICIPIO;


            $sql = "UPDATE $tablename SET
                $colnombre = :nombre, $colap = :apellidos, $colfecha = :fecha,
                $coljefe = :jefe, $colnumero = :numero, $colcalle = :calle,
                $colmunicipio = :municipio
                WHERE $colid = :id";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $dao->getId(),
                        ':nombre' => $dao->getNombre(),
                        ':apellidos' => $dao->getApellidos(),
                        ':fecha' => $dao->getFechaContrato(),
                        ':jefe' => $dao->getJefe()->getId(),
                        ':numero' => $dao->getNumero(),
                        ':calle' => $dao->getCalle(),
                        ':municipio' => $dao->getMunicipio()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;

                $this->myPDO->commit();

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                echo "Error: " . $ex->getMessage();
                $this->myPDO->rollback();
                $ok = false;
            }
            return $ok;
        }

        public function delete($id){
            $ok = true;

            $tablename = EmpleadoContract::TABLE_NAME;
            $colid = EmpleadoContract::COL_ID;

            $sqlAlum = "DELETE FROM $tablename WHERE $colid = :id";
            echo "";
            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sqlAlum);
                echo "";
                $stmt->execute(
                    [
                        ':id' => $id
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                echo "";
                $filasAfectadas = $stmt->rowCount();

                echo "<br>afectadas: ".$filasAfectadas;
                echo "";
                $this->myPDO->commit();
            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
                echo "Error: " . $ex->getMessage();
                $this->myPDO->rollback();
                $ok = false;
                echo "";
            }
            return $ok;
        }

        public function findById($id){
            $a = null;

            $tablename = EmpleadoContract::TABLE_NAME;
            $colid = EmpleadoContract::COL_ID;

            $sql = "SELECT * FROM $tablename WHERE $colid = :id";

            try{
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $id
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                //echo "<br>afectadas: ".$filasAfectadas;

                if($row = $stmt->fetch()){
                    $a = new Empleado();
                    $a->setId($row[EmpleadoContract::COL_ID]);
                    $a->setNombre($row[EmpleadoContract::COL_NOMBRE]);
                    $a->setApellidos($row[EmpleadoContract::COL_APELLIDOS]);
                    $a->setFechaContrato($row[EmpleadoContract::COL_FECHA_CONTRATO]);

                    $idJefe = $row[EmpleadoContract::COL_JEFE];
                    if(isset($idJefe)){
                        $jefe = self::findById($idJefe);
                        $a->setJefe($jefe);
                    }else{
                        //$jAux = new Empleado();
                        //$jAux->setId(null);
                        $a->setJefe(null);
                    }

                    $a->setNumero($row[EmpleadoContract::COL_NUMERO]);
                    $a->setCalle($row[EmpleadoContract::COL_CALLE]);
                    $a->setMunicipio($row[EmpleadoContract::COL_MUNICIPIO]);
                }
                return $a;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
            }
            return $a;
        }

        public function findAll(){
            $stmt = $this->myPDO->prepare("SELECT * FROM ".EmpleadoContract::TABLE_NAME);
            $stmt->setFetchMode(PDO::FETCH_ASSOC); //devuelve array asociativo
            $stmt->execute(); // Ejecutamos la sentencia
            $empleados = [];

            while ($row = $stmt->fetch()){

                $a = new Empleado();
                $a->setId($row[EmpleadoContract::COL_ID]);
                $a->setNombre($row[EmpleadoContract::COL_NOMBRE]);
                $a->setApellidos($row[EmpleadoContract::COL_APELLIDOS]);
                $a->setFechaContrato($row[EmpleadoContract::COL_FECHA_CONTRATO]);

                $idJefe = $row[EmpleadoContract::COL_JEFE];
                if(isset($idJefe)){
                    $jefe = self::findById($idJefe);
                    $a->setJefe($jefe);
                }else{
                    $a->setJefe(new Empleado());
                }

                $a->setNumero($row[EmpleadoContract::COL_NUMERO]);
                $a->setCalle($row[EmpleadoContract::COL_CALLE]);
                $a->setMunicipio($row[EmpleadoContract::COL_MUNICIPIO]);

                $empleados[] = $a;

            }
            return $empleados;
        }
    }
?>
