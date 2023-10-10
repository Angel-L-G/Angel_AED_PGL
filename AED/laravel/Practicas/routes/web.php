<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HomeController;

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

Route::get('/', function () {
    echo "normal function";
    die();
    //return view('welcome');
});

Route::get("/hola", function (){
    echo "get function";
    die();
});

Route::get("/goodbye", function (){
    return view('goodbye');
});

Route::match(['get', 'post'], '/getypost', function(){
    echo "Responde get y post";
});


Auth::routes();

Route::get('/home', [HomeController::class, 'index'])->name('home');
