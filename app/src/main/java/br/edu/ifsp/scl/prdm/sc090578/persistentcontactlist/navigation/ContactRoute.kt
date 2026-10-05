package br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.ContactViewModel
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.ui.composable.screen.ContactScreen

@Composable
fun ContactRoute(
    contactViewModel: ContactViewModel,
    modifier: Modifier = Modifier,
    onDone: () -> Unit
) {
    val contact by contactViewModel.currentContact.collectAsStateWithLifecycle()
    ContactScreen(
        contact = contact,
        modifier = modifier,
        onSaveAndQuit = { newOrEditedContact ->
            contactViewModel.saveContact(newOrEditedContact)
            onDone()
        }
    )
}