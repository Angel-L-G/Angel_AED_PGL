<?php
    namespace App\Contracts;
    
    class AlumnoContract{
        public const TABLE_NAME="alumnos";
        public const COL_ID="dni";
        public const COL_NOMBRE="nombre";
        public const COL_APELLIDOS="apellidos";
        public const COL_FECHA_NAC="fechanacimiento";
    }
?>