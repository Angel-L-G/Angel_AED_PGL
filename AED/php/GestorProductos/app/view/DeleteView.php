<?php
    class DeleteView{
        public static function form(){
            echo '
            <form action="delProd" method="post">
                <label>Introduzca el id del producto que quiera eliminar</label>
                <input type="number" name="id" id="id">
                <br/>
                <input type="submit" value="enviar" class="button">
            </form>';
        }
    }
?>