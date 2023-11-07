<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

    class User extends Model{
        private $nick;
        private $psswrd;

        public function getNick(){
            return $this->nick;
        }

        public function setNick($n){
            $this->nick = $n;
        }

        public function getPassword(){
            return $this->psswrd;
        }

        public function setPassword($p){
            $this->psswrd = $p;
        }
    }
?>