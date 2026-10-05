package br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.navigation

sealed class Screen(val route: String) {
    data object List: Screen("list_screen")
    data object Contact: Screen("contact_screen")
}