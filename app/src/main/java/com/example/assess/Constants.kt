package com.example.assess

object Constants {

    fun getQuestion(): ArrayList<Question>{

        val questionList = ArrayList<Question> ()


        val que1 = Question(1, "Access To Site",R.mipmap.canada,
            "Foot",
            "Vehicle",
            "Wheel chair Friendly"
            ,"all of the Above",
        4)

        val que2 = Question(2, "Flooring Type",R.mipmap.canada,
            "None-Slip",
            "Even",
            "Wheel chair Friendly"
            ,"all of the Above",
            4)

        val que3 = Question(3, "Access Type",R.mipmap.canada,
            "Stairs",
            "Ramp",
            "Elevator"
            ,"all of the Above",
            4)

        val que4 = Question(4, "Walkways and access around site",R.mipmap.canada,
            "Marked",
            "Signage",
            "Visible(no Obstructions)"
            ,"all of Above",
            4)


        val que5 = Question(5, "Flooring Type",R.mipmap.canada,
            "Concrete",
            "tar",
            "Paving"
            ,"Gravel",
            2)

        val que6 = Question(6, "Flooring",R.mipmap.canada,
            "Non Slip",
            "Even",
            "Well Maintained"
            ,"None the of Above",
            2)

        val que7 = Question(7, "Walkways And access around site",R.mipmap.canada,
            "Marked",
            "Signage",
            "Obstuctions"
            ,"Covered",
            4)

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)


        return questionList
    }
}