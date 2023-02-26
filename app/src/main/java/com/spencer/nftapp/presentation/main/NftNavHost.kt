package com.spencer.nftapp.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.spencer.nftapp.presentation.choose_identity.ConfirmIdentityView
import com.spencer.nftapp.presentation.login.LoginView
import com.spencer.nftapp.presentation.register.RegisterView
import com.spencer.nftapp.presentation.reset_password.ResetPasswordView
import com.spencer.nftapp.presentation.verify_identity.VerifyIdentityView
import com.spencer.nftapp.presentation.welcome.WelcomeView

@ExperimentalPagerApi
@Composable
fun NftNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController ,
        startDestination = Welcome.route,
    ) {

        composable(Welcome.route) {

            WelcomeView(navController)
        }

        composable(Login.route) {
            LoginView(navController)
        }
        composable(Register.route) {
            RegisterView(navController)
        }
        composable(ResetPassword.route) {
            ResetPasswordView(navController)
        }

        composable(ConfirmIdentity.route) {
            ConfirmIdentityView(navController)
        }

        composable(VerifyIdentity.route) {
            VerifyIdentityView(navController)
        }

    }
}