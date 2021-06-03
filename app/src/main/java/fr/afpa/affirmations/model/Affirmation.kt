package fr.afpa.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//annotations @ pour ne pas confondre les 2 Int
data class Affirmation(@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int) {
}