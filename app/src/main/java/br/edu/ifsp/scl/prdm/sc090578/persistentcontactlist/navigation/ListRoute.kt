package br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.ContactViewModel
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.model.Operation
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.ui.composable.screen.ListScreen

@Composable
fun ListRoute(contactViewModel: ContactViewModel, modifier: Modifier = Modifier, onNavigate: () -> Unit) {
    val contactList by contactViewModel.contactList.collectAsStateWithLifecycle()
    ListScreen(
        contactList = contactList,
        onViewContact = { contact ->
            contactViewModel.updateCurrentContactAndOperation(
                contact = contact,
                operation = Operation.VIEW
            )
            onNavigate()
        },
        onEditContact = { contact ->
            contactViewModel.updateCurrentContactAndOperation(
                contact = contact,
                operation = Operation.NEW_OR_EDIT
            )
            onNavigate()
        },
        onRemoveContact = { contact ->
            contactViewModel.removeContact(contact)
        },
        modifier = modifier
    )
}