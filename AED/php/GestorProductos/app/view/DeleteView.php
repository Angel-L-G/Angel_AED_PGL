<?php
    class DeleteView{
        public static function form(){
            echo '
            <form action="" method="post">
                <label>Introduzca el id del producto que quiera eliminar</label>
                <input type="number" name="deleteId" id="deleteId">
                <br/>
                <input type="submit" value="enviar">
            </form>';
        }
    }
?>