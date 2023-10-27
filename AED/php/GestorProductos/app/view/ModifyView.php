<?php
    class ModifyView{
        public static function form(){
            echo '
            <p>
            <form action="ModProd" method="post">
                <label>Product id</label>
                <input type="number" name="id" id="id">
                <br/>
                <label>Product Name</label>
                <input type="text" name="name" id="name">
                <br/>
                <label>Product category</label>
                <input type="text" name="category" id="category">
                <br/>
                <label>stock</label>
                <input type="number" name="stock" id="stock">
                <br/>
                <label>Product price</label>
                <input type="number" name="price" id="price">
                <br/>
                <input type="submit" value="enviar" class="button">
            </form>
            </p>';
        }
    }
?>