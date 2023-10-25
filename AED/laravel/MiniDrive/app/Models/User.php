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
            return "nick: " . $this->nick 
            . " name: " . $this->name
            . " psswrd: " . $this->psswrd;
        }
    }
?>
