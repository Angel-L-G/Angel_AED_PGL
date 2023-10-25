<?php

    namespace App\DAO;

    interface ICrud{
        public function save($dao);

        public function update($dao);

        public function delete($id);

        public function findById($id);

        public function findAll();
    }

?>
