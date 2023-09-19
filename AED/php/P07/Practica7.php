<?php
    function foo(){
        unset($GLOBALS['bar']);
    }

    $bar = "algo";
    foo();
?>

<?php
    function destruir_foo(){
        global $foo;
        unset($foo);
    }
    $foo = 'bar';
    destruir_foo();
    echo $foo;
?>