package br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist

import androidx.lifecycle.ViewModel
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.model.Contact
import br.edu.ifsp.scl.prdm.sc090578.persistentcontactlist.model.Contact.Companion.INVALID_CONTACT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContactViewModel: ViewModel() {
    private val _currentContact = MutableStateFlow(Contact())
    val currentContact: StateFlow<Contact> = _currentContact.asStateFlow()

    private val _contactList: MutableStateFlow<List<Contact>> = MutableStateFlow(emptyList())
    val contactList: StateFlow<List<Contact>> = _contactList.asStateFlow()

    private var nextId = 0
    fun saveContact(contact: Contact) {
        if (contact.id == INVALID_CONTACT_ID) {
            _contactList.update{ it + contact.copy(id = nextId++)}
        }
        else {
            _contactList.update { list -> list.map{ if (it.id == contact.id) contact else it } }
        }
    }
}