<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Numeros</title>
</head>
<body>
    <!--  -->
    <form action="<?php echo $_SERVER['SCRIPT_NAME'] ?>" method="post">
        <input type="text" name="nums" id="nums">
        <input type="submit" value="enviar">  
    </form>
    <?php
        $res  = "";
        $nums = explode(" ",$_POST['nums']);
        
        for ($i=0; $i < count($nums); $i++) { 
            $a = (int)$nums[$i];
            if($a % 2 == 0){
                $res .= "<br>" . $nums[$i];
            }else{
                $res = "<br>" . $nums[$i] . $res;
            }
            echo "<br>" . $nums[$i];
        }

    ?>    
</body>
</html>
