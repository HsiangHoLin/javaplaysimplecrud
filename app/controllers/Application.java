package controllers;

import com.avaje.ebean.*;
import play.*;
import play.data.Form;
import play.mvc.*;
import models.Person;

import views.html.*;
import java.util.List;
import static play.libs.Json.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result addPerson() {
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }

    public Result delPerson(String personId) {
        Person person =  Ebean.find(Person.class, personId);
        person.delete();
        return redirect(routes.Application.index());
    }

    public Result upPerson(String personId) {
        Person person =  Ebean.find(Person.class, personId);
        Person tmp = Form.form(Person.class).bindFromRequest().get();
        person.name = tmp.name;
        person.save();
        return redirect(routes.Application.index());
    }

    public Result getPersons() {
        List<Person> persons =  Ebean.find(Person.class).findList();
        return ok(toJson(persons));
    }
}
