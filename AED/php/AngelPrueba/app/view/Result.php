<?php
    class Result{
        public static function generateRes(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Resultados</title>";
            echo "</head>";
            echo "<body>";
                    
                $fileGuess = "app/model/Guess.dat";
                $fileRand = "app/model/Rand.dat";

                $guesses = [];

                if(file_exists($fileGuess)){
                    $sGuesess = file_get_contents($fileGuess);
                    $guesses = unserialize($sGuesess);
                    if($guesses == false){
                        $guesses = [];
                    }
                }
                
                $rand = file_get_contents($fileRand);

                $guess = $_REQUEST["guess"];
                $strRes = "";

                if($guess == $rand){
                    echo "<h2>Has Ganado</h2>";
                    echo "<p>El numero era: $rand</p>";
                    unlink($fileRand);
                }else{
                    if($guess < $rand){
                        $strRes = "$guess es menor que el anonimo<br>";
                    }else{
                        $strRes = "$guess es mayor que el anonimo<br>";
                    }
                    array_push($guesses,$strRes);
                }

                $sGuesses = serialize($guesses);
                file_put_contents($fileGuess,$sGuesses);

                foreach ($guesses as $key => $value) {
                    echo "$value";
                }

                echo "<form action='adivinar/index' method='post'>";
                    echo "<input type='submit' value='Reiniciar'>";
                echo "</form>";

            echo "</body>";
            echo "</html>";
        }
    }
?>