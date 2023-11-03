<?php
    namespace App\Models;

    class Asignatura{
        private $id;
        private $nombre;
        private $curso;

        public function getId(){
            return $this->id;
        }

        public function setId($d){
            $this->id = $d;
        }

        public function getnombre(){
            return $this->nombre;
        }

        public function setNombre($n){
            $this->nombre = $n;
        }

        public function getCurso(){
            return $this->curso;
        }

        public function setCurso($c){
            $this->curso = $c;
        }
    }
?>