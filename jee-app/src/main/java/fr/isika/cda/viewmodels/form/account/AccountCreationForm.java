package fr.isika.cda.viewmodels.form.account;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Address;
import fr.isika.cda.model.entities.Contact;
import fr.isika.cda.model.factories.implementation.AccountFactoryImpl;
import fr.isika.cda.model.factories.implementation.AddressFactoryImpl;
import fr.isika.cda.model.factories.implementation.ContactFactoryImpl;

public abstract class AccountCreationForm {
    protected Address address;
    protected Contact contact;
    protected Account account;

    public AccountCreationForm(){
        this.account = AccountFactoryImpl.getInstance().getAccount();
        this.address = AddressFactoryImpl.getInstance().getAddress();
        this.contact = ContactFactoryImpl.getInstance().getContact();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
