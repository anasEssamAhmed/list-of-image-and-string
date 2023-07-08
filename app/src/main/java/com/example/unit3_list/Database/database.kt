package com.example.unit3_list.Database

import com.example.unit3_list.R
import com.example.unit3_list.model.Affirmation

class database {
    fun loadAffirmations():List<Affirmation>{
        return listOf(
            Affirmation(R.string.image1 , R.drawable.image1),
            Affirmation(R.string.image2 , R.drawable.image2),
            Affirmation(R.string.image3 , R.drawable.image3),
            Affirmation(R.string.image4 , R.drawable.image4),
            Affirmation(R.string.image5 , R.drawable.image5),
            Affirmation(R.string.image6 , R.drawable.image6),
            Affirmation(R.string.image7 , R.drawable.image7),
            Affirmation(R.string.image8 , R.drawable.image8),
            Affirmation(R.string.image9 , R.drawable.image9),
            Affirmation(R.string.image10 , R.drawable.image10),
        )
    }
}