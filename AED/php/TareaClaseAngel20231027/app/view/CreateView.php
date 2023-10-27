<?php
    class CreateView{
        public function form(){
            echo '
                <form action="createText" method="post">
                    <label>Author</label>
                    <input type="text" name="author" id="author">
                    <br/>
                    <label>Titel</label>
                    <input type="text" name="titel" id="titel">
                    <br/>
                    <label>Description</label>
                    <textarea type="text" name="desc" id="desc"></textArea>
                    <br/>
                    <input type="submit" value="enviar" class="button">
                </form>
            ';
        }
    }

?>