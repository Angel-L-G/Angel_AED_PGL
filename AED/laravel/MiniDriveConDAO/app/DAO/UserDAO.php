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

        public function save($p){
            $tablename = UserContract::TABLE_NAME;
            $colid = UserContract::COL_ID;
            $colnombre = UserContract::COL_NICK;
            $colpsswd = UserContract::COL_PSSWRD;

            $sql = "INSERT INTO $tablename ($colid, $colnombre, $colpsswd)
            VALUES(NULL,:nombre, :password);";
    
            try {
    
                $this->myPDO->beginTransaction();
    
                $stmt = $this->myPDO->prepare($sql);
    
                $stmt->execute(
                    [
                        ':nombre' => $p->getNick(),
                        ':password' => $p->getPassword(),
                    ]
    
                );
                $idgenerado = $this->myPDO->lastInsertId();
                $nombre = $p->nick;
                $password = $p->password;
                $p = new User();
                $p->setId($idgenerado);
                $p->setNick($nombre);
                $p->setPassword($password);
                $filasAfectadas = $stmt->rowCount();

                if ($filasAfectadas > 0) {
                    $this->myPDO->commit();
                    return $p;
                } else {
                    return null;
                }
            } catch (Exception $ex) {
                echo "Error: " . $ex->getMessage();
                $this->myPDO->rollback();
            }
            $stmt = null;
        }

        public function update($user){
            /*$error = false;

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
                        ':id' => $user->getId(),
                        ':psswrd' => $user->getPassword()
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
            return $error;*/
        }

        public function findAll(){
            $stmt = $this->myPDO->prepare("SELECT * FROM ".UserContract::TABLE_NAME);
            $stmt->setFetchMode(PDO::FETCH_ASSOC); //devuelve array asociativo
            $stmt->execute(); // Ejecutamos la sentencia
            $alumnos = [];

            while ($row = $stmt->fetch()){
                
                $a = new User();
                $a->setId($row[UserContract::COL_ID]);
                $a->setNick($row[UserContract::COL_NICK]);
                $a->setPassword($row[UserContract::COL_PSSWRD]);

                $alumnos[] = $a;
                
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
                    $a = new User();
                    $a->setId($row[UserContract::COL_ID]);
                    $a->setNick($row[UserContract::COL_NICK]);
                    $a->setPassword($row[UserContract::COL_PSSWRD]);
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