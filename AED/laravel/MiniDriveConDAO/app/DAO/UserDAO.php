<?php
    namespace App\DAO;

    use App\DAO\ICrud;
    use App\Models\User;
    use App\Contracts\UserContract;
    use Exception;
    use PDO;

    class UserDAO implements ICrud{
        private $myPDO;

        public function __construct($pdo){
            $this->myPDO = $pdo;
        }

        public function save($user){
            $res = null;

            $tablename = UserContract::TABLE_NAME;
            $colid = UserContract::COL_ID;
            $colpsswrd = UserContract::COL_PSSWRD;

            $sql = "INSERT INTO $tablename ($colid, $colpsswrd)
            VALUES(:id, :psswrd)";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':id' => $user->getNick(),
                        ':psswrd' => $user->getPassword()
                    ]
                );

                //si filasAfectadas > 0 => hubo éxito consulta
                $filasAfectadas = $stmt->rowCount();

                if($filasAfectadas > 0){
                    $res = $user;
                }

                //echo "<br>afectadas: ".$filasAfectadas;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
            }
            $stmt = null;

            return $res;
        }

        public function update($user){
            $error = false;

            $tablename = UserContract::TABLE_NAME;
            $colid = UserContract::COL_ID;
            $colpsswrd = UserContract::COL_PSSWRD;

            $sql = "UPDATE $tablename SET $colpsswrd = :psswrd
            WHERE $colid = :id";

            try{
                $this->myPDO->beginTransaction();
                $stmt = $this->myPDO->prepare($sql);

                $stmt->execute(
                    [
                        ':psswrd' => $user->getNick(),
                        ':id' => $user->getPassword()
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
            $stmt = $this->myPDO->prepare("SELECT * FROM ".UserContract::TABLE_NAME);
            $stmt->setFetchMode(PDO::FETCH_ASSOC); //devuelve array asociativo
            $stmt->execute(); // Ejecutamos la sentencia
            $alumnos = [];

            while ($row = $stmt->fetch()){
                /*
                $a = new User();
                $a->setNick($row[UserContract::COL_ID]);
                $a->setPassword($row[UserContract::COL_PSSWRD]);

                $alumnos[] = $a;
                */
            }
            return $alumnos;
        }

        public function findById($id){
            $a = null;

            $tablename = UserContract::TABLE_NAME;
            $colid = UserContract::COL_ID;

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
                    /*
                    $a = new User();
                    $a->setDni($row[UserContract::COL_ID]);
                    $a->setNombre($row[UserContract::COL_PSSWRD]);
                    */
                }
                return $a;

            }catch(Exception $ex){
                echo "ha habido una excepción se lanza rollback automático";
            }
            return $a;
        }

        public function delete($id){
            $error = false;

            $tablename = UserContract::TABLE_NAME;
            $colid = UserContract::COL_ID;

            $sqlAlum = "DELETE FROM $tablename WHERE $colid = :id";

            try{
                $stmt = $this->myPDO->prepare($sqlAlum);

                $stmt->execute(
                    [
                        ':id' => $id
                    ]
                );

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