<?php
    namespace App\Models;

    class Matricula{
        private $idmatricula;
        private $dni;
        private $year;
        private $asignaturas = [];
        
        public function getIdmatricula(){
            return $this->idmatricula;
        }

        public function setIdmatricula($id){
            $this->idmatricula = $id;
        }

        public function getDni(){
            return $this->dni;
        }

        public function setDni($d){
            $this->dni = $d;
        }

        public function getYear(){
            return $this->year;
        }

        public function setYear($f){
            $this->year = $f;
        }

        public function getAsignaturas(){
            return $this->asignaturas;
        }

        public function setAsignaturas($arr){
            $this->asignaturas = $arr;
        }
    }
?>