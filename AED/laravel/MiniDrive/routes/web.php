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
Route::any("/", function() {return view("Login");});
Route::any('/showRegister', function() {return view("Register");});
Route::any('/Register', [UserController::class,'Register']);
Route::any('/showLogin', function() {return view("Login");});
Route::any('/logIn', [UserController::class, 'logIn']);
Route::any('/logOut', [UserController::class, 'logOut']);

Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');
