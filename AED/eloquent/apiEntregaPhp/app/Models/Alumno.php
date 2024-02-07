<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * @property string $dni
 * @property string $created_at
 * @property string $updated_at
 * @property string $nombre
 * @property string $apellido
 * @property integer $fechanacimiento
 * @property string $imagen
 */
class Alumno extends Model
{
    protected $dni;
    protected $nombre;
    protected $apellido;
    protected $fechanacimiento;
    protected $imagen;

    /**
     * The primary key for the model.
     *
     * @var string
     */
    protected $primaryKey = 'dni';

    /**
     * The "type" of the auto-incrementing ID.
     *
     * @var string
     */
    protected $keyType = 'string';

    /**
     * Indicates if the IDs are auto-incrementing.
     *
     * @var bool
     */
    public $incrementing = false;

    /**
     * @var array
     */
    protected $fillable = ['dni','created_at', 'updated_at', 'nombre', 'apellido', 'fechanacimiento', 'imagen'];
}
