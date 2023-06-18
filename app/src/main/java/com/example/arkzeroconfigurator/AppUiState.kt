package com.example.arkzeroconfigurator

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

/*
Records the state of the configurated car.

Trim codes:
c - Core  p - Progressive  g - GT Pro  z - GT Performance  x - GT Performance e4X

Color codes:
w - Pure White  j - Jet Black  s - Clear Sky  k - Knights Silver  m - Mystic Red  o - orient teal
g - Storm Gray  b - Supersonic Blue  a - Aqua Regia Metallic  r - Royal Emerald Metallic
x - Alchemist's Blue

Wheel codes:
a b c d e

Interior codes:
b - Blue + White  c - Carbon + Alcantara  g - Geometric Microfiber  c - Grey Microfiber
r - Red Leather  d - White + Black  t - Tan Leather  w - White Leather

 */
data class AppUiState(
    val g: Int = 1
    /*
    val trimCode: Char = 'x',
    val colorCode: Char = 'm',
    val wheelCode: Char = when(trimCode){
        'c' -> 'a'
        'p' -> 'b'
        'g' -> 'c'
        'z' -> 'd'
        'x' -> 'e'
        else -> 'o'
    },
    val interiorCode: Char = 'b',
    val options: ArrayList<Char> = ArrayList(),
    val mainCode: Array<Char> = arrayOf(trimCode, colorCode, wheelCode, interiorCode),

     */

)
