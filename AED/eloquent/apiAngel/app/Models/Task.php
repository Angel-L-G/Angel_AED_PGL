<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * @property integer $id
 * @property string $created_at
 * @property string $updated_at
 * @property string $subject
 * @property boolean $terminada
 */
class Task extends Model
{
    protected $id;
    protected $subject;
    protected $terminada;
    /**
     * @var array
     */
    protected $fillable = ['created_at', 'updated_at', 'subject', 'terminada'];
}
