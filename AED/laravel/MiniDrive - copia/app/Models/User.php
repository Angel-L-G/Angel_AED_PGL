<?php
namespace App\Models;
    class User{
        public $nick;
        public $name;
        public $psswrd;

        public function __construct($nick, $name, $psswrd){
            $this->nick = $nick;
            $this->name = $name;
            $this->psswrd = $psswrd;
        }

        public function __toString(){
            return $this->nick 
            . ";" . $this->name
            . ";" . $this->psswrd;
        }
    }
?>
