import java.awt.event.*;
import model.*;

/**
 *  Controller in a MVC gui.
 *  Both Model and View expose objects that must be connected.
 *  The constructor makes the connection using inner anonymous classes.
 */
public class Controller {
    private View view;
    private Model model;
    /**
     *  Construct this controller.
     *  Define a suitable listener for the widgets of the View,
     *  and call appropriate methods of the Model.
     *  @param v The view.
     *  @param m The model.
     */
    public Controller (View v, Model m) {
//+ Store args values in class so nested classes can get them
        view = v;
        model = m;
        view.regular.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
//+ One cannot reference argument "m" of constructor here.
//+ Rather one must use instance variable "model" of class Controller.
//+ Attempt to use a non-final variable model from a different method.
//+ From enclosing blocks, only final local variables are available.
//+ It is the same for "v" versus "view" in following listeners.
                    model.setCondition (model.regular);
        }});
        view.gravel.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
                    model.setCondition (model.gravel);
        }});
        view.wet.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
                    model.setCondition (model.wet);
        }});
        view.ice.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
                    model.setCondition (model.ice);
        }});
	view.accel.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
                    view.result.setText (""+model.getAccel ());
        }});
	view.left.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
                    view.result.setText (""+model.getLeft ());
        }});
	view.right.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
                    view.result.setText (""+model.getRight ());
        }});
	view.brake.addActionListener (
            new ActionListener () {
                public void actionPerformed (ActionEvent evt) {
                    view.result.setText (""+model.getBrake ());
        }});
    }
}
