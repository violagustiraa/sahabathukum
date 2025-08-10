package com.example.sahabathukum

sealed interface RallyDestination {
    val route: String
}

data object Login : RallyDestination {
    override val route = "login"
}

data object Login2 : RallyDestination {
    override val route = "login2"
}

data object SignUp : RallyDestination {
    override val route = "signup"
}

data object DataDiri : RallyDestination {
    override val route = "datadiri"
}
