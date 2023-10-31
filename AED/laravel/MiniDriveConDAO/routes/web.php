<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

use App\Http\Controllers\UserController;
use App\Http\Controllers\FileController;

use App\Http\Controllers\PersonaController;

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

Route::any('/showUpload', function() {return view("Upload");});
Route::any('/Upload', [FileController::class, 'uploadFile']);
Route::any('/showFiles', [FileController::class, 'showFiles']);
Route::any('/Delete/{fich}', [FileController::class, 'deleteFile']);
Route::any('/Download/{fich}', [FileController::class, 'downloadFile']);

Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

Route::any("/personas/mostrar", [PersonaController::class, "obtenerPersonas"]);
Route::any("/personas/save", [PersonaController::class, "guardarPersonas"]);
Route::any("/personas/update", [PersonaController::class, "updatePersona"]);
Route::any("/personas/delete", [PersonaController::class, "deletePersona"]);
