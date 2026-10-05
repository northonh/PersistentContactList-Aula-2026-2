package br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.ContactViewModel
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.ui.composable.screen.ContactScreen
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.ui.composable.screen.ListScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    contactViewModel: ContactViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.List.route,
        modifier = modifier
    ) {
        composable(route = Screen.List.route) {
            ListRoute(contactViewModel)
        }
        composable(route = Screen.Contact.route) {
            ContactRoute(contactViewModel) { navHostController.popBackStack() }
        }
    }
}
