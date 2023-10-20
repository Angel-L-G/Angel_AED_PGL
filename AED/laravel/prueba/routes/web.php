<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use \App\Http\Controllers\HomeController;
use \App\Http\Controllers\HomeController as PruebaController;
use \App\Http\Controllers\ListarProductos;
use \App\Http\Controllers\ControladorNumeros;
use App\Http\Controllers\PrimosController;
use App\Http\Controllers\HoraController;
use App\Http\Controllers\ImgController;
use App\Http\Controllers\UserController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

/*Route::post('/pruebita', function () { //Practica 1
    echo 'Se ha ejecutado la peticion post en: /pruebita';
});

Route::get('/', function () { //Practica 2
    echo 'Under Cosntruction';
});

Route::any('/relatos/numero/{num}', function ($num){ //Practica 3
    echo "Num: $num";
});

Route::get('/', function (){ // Practica 4
    echo "Pagina Raiz response: ";
    PruebaController::P04();
    die();
});

Route::any('/', function (){ // Practica 5
    echo "Ejecutando el controlador ListarProductos mediante: " . $_SERVER['REQUEST_METHOD'];
    ListarProductos::listar();
    die();
});*/

Route::any("/nums",[ControladorNumeros::class, 'generar']);

Route::any('/primos', [PrimosController::class, 'primos']);

Route::any('/showHora', [HoraController::class, 'showHora']);

Route::any('/horaFromBefore', [HoraController::class, 'horaFromBefore']);

Route::any('/imagenes', [ImgController::class, 'showImg']); // Practica 12

Route::any('/Pract13', [HomeController::class, 'P13']); // Practica 13-14

// Practica 16 con ficheros
Route::any('/showRegister', function() {return view("Register");});
Route::any('/Register', [UserController::class,'Register']);
Route::any('/showLogin', function() {return view("Login");});
Route::any('/logIn', [UserController::class, 'logIn']);
Route::any('/logOut', [UserController::class, 'logOut']);

Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');
