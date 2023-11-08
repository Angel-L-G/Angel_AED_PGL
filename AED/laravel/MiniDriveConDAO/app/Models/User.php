<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

    class User extends Model{
        private $id;
        private $nick;
        private $psswrd;

        public function __construct(){}

        public function getId(){
            return $this->id;
        }

        public function setId($n){
            $this->id = $n;
        }

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