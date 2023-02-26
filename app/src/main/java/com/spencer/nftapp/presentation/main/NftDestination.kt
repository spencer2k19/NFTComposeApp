package com.spencer.nftapp.presentation.main

interface NftDestination {
    val route:String
}


object Welcome:NftDestination {
    override val route: String
        get() = "welcome"
}

object Login:NftDestination {
    override val route: String
        get() = "login"
}

object Register:NftDestination {
    override val route: String
        get() = "register"
}

object ConfirmIdentity:NftDestination {
    override val route: String
        get() = "confirm_identity"
}

object VerifyIdentity:NftDestination {
    override val route: String
        get() = "verify_identity"
}


object ResetPassword:NftDestination {
    override val route: String
        get() = "reset_password"
}


object CreatePinCode:NftDestination {
    override val route: String
        get() = "create_pin_code"
}