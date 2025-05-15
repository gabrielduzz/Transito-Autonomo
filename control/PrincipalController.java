/********************************************************************
* Autor: Gabriel dos Santos
* Inicio: 21/11/2023
* Ultima alteracao: 
* Nome: PrincipalController.java
* Funcao: Gerenciar os objetos da cena e inicializar as threads
********************************************************************/

package control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import javafx.fxml.FXML;
import java.lang.System;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Car;

public class PrincipalController implements Initializable{

  @FXML private ImageView black_car_image;
  @FXML private Slider black_car_slider;
  @FXML private ImageView gray_car_image;
  @FXML private Slider gray_car_slider;
  @FXML private ImageView red_car_image;
  @FXML private Slider red_car_slider;
  @FXML private ImageView purple_car_image;
  @FXML private Slider purple_car_slider;
  @FXML private ImageView aqua_car_image;
  @FXML private Slider aqua_car_slider;
  @FXML private ImageView orange_car_image;
  @FXML private Slider orange_car_slider;
  @FXML private ImageView blue_car_image;
  @FXML private Slider blue_car_slider;
  @FXML private ImageView light_green_car_image;
  @FXML private Slider light_green_car_slider;
  @FXML private ImageView pause1;
  @FXML private ImageView pause2;
  @FXML private ImageView pause3;
  @FXML private ImageView pause4;
  @FXML private ImageView pause5;
  @FXML private ImageView pause6;
  @FXML private ImageView pause7;
  @FXML private ImageView pause8;
  @FXML private ImageView route_button1;
  @FXML private ImageView route_button2;
  @FXML private ImageView route_button3;
  @FXML private ImageView route_button4;
  @FXML private ImageView route_button5;
  @FXML private ImageView route_button6;
  @FXML private ImageView route_button7;
  @FXML private ImageView route_button8;
  @FXML private ImageView black_route;
  @FXML private ImageView gray_route;
  @FXML private ImageView red_route;
  @FXML private ImageView purple_route;
  @FXML private ImageView aqua_route;
  @FXML private ImageView orange_route;
  @FXML private ImageView blue_route;
  @FXML private ImageView green_route;
  @FXML private ImageView reset_button;
  @FXML private ImageView close_button;

  Car black_car;
  String[] black_car_command_array = 
  {"left", "-:2:0", "down", "-:4:1", "+:4:1", "+:1:1", "down", "-:6:1", "down", "-:7:1", "-:3:0", "+:6:1", "left", "-:1:0", "+:7:1", "+:3:0", 
  "left", "-:1:6", "+:1:0", "up", "up", "-:1:4", "-:7:0", "-:6:0", "-:4:0", "+:1:6", "up", "+:7:0", "+:6:0", "up", "up", "-:1:5", "+:1:4", "right", "-:7:2",
  "-:3:2", "right", "-:6:2", "+:1:5", "+:2:0", "right", "-:5:0", "-:1:2", "+:3:2", "+:4:0", "+:6:2", "right", "+:7:2", "right",
  "down", "down", "-:1:3", "-:5:1", "-:7:4", "-:6:4", "+:1:2", "+:5:0", "down", "+:7:4", "+:6:4", "down", "down", "left", "-:5:2", "-:7:3",
  "+:5:1", "+:1:3", "left", "-:6:3", "-:3:1", "+:7:3",  "up", "+:6:3", "up", "-:1:1", "-:4:2", "up", "+:3:1", "+:4:2", "+:5:2", "reset"};

  Car gray_car;
  String[] gray_car_command_array = 
  {"right", "-:6:3", "-:5:1", "-:3:3", "-:4:3", "up", "-:0:2", "-:7:4", "+:6:3", "+:3:3", "+:4:3", "right", "+:7:4", "right", "down",
  "down", "-:0:3", "-:5:2", "-:6:5", "-:7:5", "+:5:1", "+:0:2", "down", "+:7:5", "+:6:5", "down", "down", "left", "-:7:3", "+:5:2",
  "+:0:3", "up", "-:6:4", "up", "+:7:3", "+:6:4", "left", "-:0:1", "-:4:2", "-:3:2", "-:5:0", "up", "+:5:0", "+:4:2", "+:3:2", "left", "-:2:1",
  "down", "-:4:1",  "+:0:1", "+:2:1", "left", "-:3:0", "-:7:1", "-:6:1", "+:4:1", "down", "-:7:6", "+:7:1", "+:6:1", "down", "-:2:0",
  "-:0:0", "+:7:6", "+:3:0", "left", "-:0:6", "+:0:0", "up", "up", "-:0:4", "-:7:0", "-:6:0", "-:4:0", "+:0:6", "up", "+:7:0", "+:6:0",
  "up", "up", "-:0:5", "+:0:4", "right", "-:3:1", "-:7:2", "right", "-:6:2", "+:7:2", "+:4:0", "+:3:1", "+:0:5", "down", "+:6:2", "+:2:0", "reset"};

  Car red_car;
  String[] red_car_command_array = 
  {"up", "-:6:2", "-:1:0", "up", "-:0:0", "-:3:1", "-:4:1", "-:7:2", "+:6:2", "left", "+:7:2", "+:3:1", "left", "down", "down", "-:7:0",
  "-:6:0", "down", "+:7:0", "+:6:0", "+:4:1", "down", "down", "right", "-:7:1", "-:3:0", "+:1:0", "right", "-:6:1", "+:7:1", "+:3:0",
  "up", "+:6:1", "up", "-:1:1", "-:4:0", "+:4:0", "up", "+:0:0", "+:1:1", "reset"};

  Car purple_car;
  String[] purple_car_command_array = 
  {"down", "-:7:0", "-:1:0", "-:4:0", "-:6:0", "+:4:0", "down", "+:6:0", "down", "-:7:2", "-:2:0", "-:0:0", "+:7:0", "+:1:0", "right",
  "-:6:2", "+:0:0", "+:2:0", "right", "-:0:1", "-:5:0", "+:7:2", "up", "+:6:2", "up", "-:5:1", "-:1:2", "-:4:1", "+:5:0", "up", "+:1:2",
  "+:0:1", "up", "-:6:3", "-:1:3", "up", "-:7:1", "-:0:2", "+:1:3", "+:5:1", "left", "-:1:1", "-:2:1", "+:6:3", "left", "+:1:1", "+:0:2",
  "+:4:1", "+:2:1", "down", "-:6:1", "down", "+:7:1", "+:6:1", "reset"};

  Car aqua_car;
  String[] aqua_car_command_array = 
  {"right", "-:5:0", "-:0:2", "-:1:2", "-:3:1", "up", "+:1:2", "+:0:2", "up", "-:6:1", "-:1:3", "up", "-:0:0", "-:7:1",
  "+:1:3", "+:5:0", "left", "-:1:0", "-:2:1", "+:6:1", "left", "+:3:1", "+:7:1", "left", "down", "down", "-:7:0", "-:6:0", "down", "+:1:0",
  "+:0:0", "+:2:1", "right", "-:1:1", "-:3:0", "+:3:0", "+:7:0", "+:6:0", "right", "-:0:1", "-:2:0", "+:0:1", 
  "+:2:0", "+:1:1", "reset"};

  Car orange_car;
  String[] orange_car_command_array = 
  {"up", "-:3:1", "-:4:0", "-:1:0", "+:3:0", "up", "+:0:2", "+:1:0", "up", "-:1:1", "-:6:1", "up", "-:0:0", "-:7:1", "+:3:1", "+:4:0", "+:6:1",
  "right", "+:7:1", "right", "down", "down", "-:0:1", "-:1:2", "-:6:2" , "-:7:2", "+:0:0", "+:1:1", "down", "+:7:2", "+:6:2", "down", "down", "left",
  "-:0:2", "-:7:0", "+:0:1", "+:1:2", "left", "-:3:0", "-:6:0", "+:7:0", "up", "+:6:0", "reset"};

  Car blue_car;
  String[] blue_car_command_array = 
  {"left", "-:1:3", "-:4:1", "-:5:1", "-:3:3", "up", "-:2:2", "-:0:2", "-:7:2", "+:1:3", "+:5:1", "left", "-:1:2", "+:0:2", "+:7:2", "+:3:3",
  "+:4:1", "down", "+:1:2", "+:2:2", "left", "-:7:0", "-:3:1", "down", "+:3:1", "left", "-:1:0", "-:2:0", "-:4:0", "-:0:0", 
  "down", "+:0:0", "+:1:0", "+:2:0", "right", "-:1:1", "-:3:0", "+:4:0", "down", "+:7:0", "+:1:1", "+:3:0", "right", "-:0:1", "-:2:1", 
  "down", "-:7:1", "-:3:2", "+:0:1", "+:2:1", "right", "-:0:3", "-:5:0", "+:7:1", "up", "+:0:3", "+:3:2", "+:5:0", "right", "-:7:3", "-:1:4",
  "up", "+:1:4", "right", "-:0:4", "-:1:5", "-:5:2", "up", "+:1:5", "+:0:4", "+:5:2", "left", "up", "+:7:3", "reset"};

  Car light_green_car;
  String[] light_green_car_command_array =
  {"up", "-:0:2", "-:1:4", "-:5:1", "left", "-:3:1", "-:4:1", "-:6:2", "+:1:4", "+:5:1", "left", "-:2:2", "-:1:2", "+:6:2", "left", "+:1:2",
  "+:0:2", "+:2:2", "+:4:1", "down", "-:6:0", "down", "+:3:1", "left", "-:1:0", "-:0:0", "-:4:0", "-:2:0", "down", "+:1:0", "+:0:0",
  "+:2:0", "right", "-:3:0", "-:1:1",  "+:4:0", "down", "-:1:6", "+:1:1", "+:6:0", "down", "-:0:1", "-:2:1", "-:3:2", "+:3:0", "+:1:6",
  "right", "-:6:1", "+:0:1", "+:2:1", "right", "-:0:3", "-:5:0",  "+:3:2", "+:6:1", "right", "-:1:3", "+:0:3", "+:5:0", "up", "-:6:3", "up",
  "+:1:3", "right", "-:0:4", "-:5:2", "-:1:5", "up", "+:0:4", "+:5:2", "+:1:5", "left", "up", "+:6:3", "reset"};  
  
  
  Semaphore[] red_black = new Semaphore[1];
  Semaphore[] red_gray = new Semaphore[2];
  Semaphore[] red_purple = new Semaphore[2];
  Semaphore[] red_aqua = new Semaphore[2];
  Semaphore[] red_blue = new Semaphore[3];
  Semaphore[] red_green = new Semaphore[3];
  Semaphore[] purple_black = new Semaphore[3];
  Semaphore[] purple_gray = new Semaphore[4];
  Semaphore[] purple_aqua = new Semaphore[2];
  Semaphore[] purple_orange = new Semaphore[2];
  Semaphore[] purple_blue = new Semaphore[4];
  Semaphore[] purple_green = new Semaphore[3];
  Semaphore[] aqua_black = new Semaphore[3];
  Semaphore[] aqua_gray = new Semaphore[4];
  Semaphore[] aqua_orange = new Semaphore[1];
  Semaphore[] aqua_blue = new Semaphore[2];
  Semaphore[] aqua_green = new Semaphore[2];
  Semaphore[] black_gray = new Semaphore[7];
  Semaphore[] black_orange = new Semaphore[3];
  Semaphore[] black_blue = new Semaphore[5];
  Semaphore[] black_green = new Semaphore[5];
  Semaphore[] gray_orange = new Semaphore[3];
  Semaphore[] gray_blue = new Semaphore[6];
  Semaphore[] gray_green = new Semaphore[7];
  Semaphore[] orange_blue = new Semaphore[3];
  Semaphore[] orange_green = new Semaphore[3];
  Semaphore[] blue_green = new Semaphore[4];
  
  Semaphore[] null_sem = new Semaphore[1];

  private Semaphore[][] black_semaphores = {null_sem, black_gray, red_black, purple_black, aqua_black, black_orange, black_blue, black_green};
  private Semaphore[][] gray_semaphores = {black_gray, null_sem, red_gray, purple_gray, aqua_gray, gray_orange, gray_blue, gray_green};
  private Semaphore[][] red_semaphores = {red_black, red_gray, null_sem, red_purple, red_aqua, null_sem, red_blue, red_green};
  private Semaphore[][] purple_semaphores = {purple_black, purple_gray, red_purple, null_sem, purple_aqua, purple_orange, purple_blue, purple_green};
  private Semaphore[][] aqua_semaphores = {aqua_black, aqua_gray, red_aqua, purple_aqua, null_sem, aqua_orange, aqua_blue, aqua_green};
  private Semaphore[][] orange_semaphores = {black_orange, gray_orange, null_sem, purple_orange, aqua_orange, null_sem, orange_blue, orange_green};
  private Semaphore[][] blue_semaphores = {black_blue, gray_blue, red_blue, purple_blue, aqua_blue, orange_blue, null_sem, blue_green};
  private Semaphore[][] light_green_semaphores = {black_green, gray_green, red_green, purple_green, aqua_green, orange_green, blue_green, null_sem};
  
  public void initialize_semaphores(){
    for(int i = 0; i < red_purple.length; i++){
      red_purple[i] = new Semaphore(1);
    }
    for(int i = 0; i < red_aqua.length; i++){
      red_aqua[i] = new Semaphore(1);
    }
    for(int i = 0; i < red_black.length; i++){
      red_black[i] = new Semaphore(1);
    }
    for(int i = 0; i < purple_aqua.length; i++){
      purple_aqua[i] = new Semaphore(1);
    }
    for(int i = 0; i < purple_black.length; i++){
      purple_black[i] = new Semaphore(1);
    }
    for(int i = 0; i < aqua_black.length; i++){
      aqua_black[i] = new Semaphore(1);
    }
    for(int i = 0; i < red_gray.length; i++){
      red_gray[i] = new Semaphore(1);
    }
    for(int i = 0; i < purple_gray.length; i++){
      purple_gray[i] = new Semaphore(1);
    }
    for(int i = 0; i < aqua_gray.length; i++){
      aqua_gray[i] = new Semaphore(1);
    }
    for(int i = 0; i < black_gray.length; i++){
      if(i == 1){
        black_gray[i] = new Semaphore(0);
      }
      else{
        black_gray[i] = new Semaphore(1);
      }
    }
    for(int i = 0; i < purple_orange.length; i++){
      if(i == 0){
        purple_orange[i] = new Semaphore(0);
      }
      else{
        purple_orange[i] = new Semaphore(1);
      }
    }
    for(int i = 0; i < black_orange.length; i++){
      if(i == 2){
        black_orange[i] = new Semaphore(0);
      }
      else{
        black_orange[i] = new Semaphore(1);
      }
    }
    for(int i = 0; i < gray_orange.length; i++){
      gray_orange[i] = new Semaphore(1);
    }
    for(int i = 0; i < aqua_orange.length; i++){
      aqua_orange[i] = new Semaphore(1);
    }
    for(int i = 0; i < aqua_blue.length; i++){
      aqua_blue[i] = new Semaphore(1);
    }
    for(int i = 0; i < orange_blue.length; i++){
      orange_blue[i] = new Semaphore(1);
    }
    for(int i = 0; i < purple_blue.length; i++){
      purple_blue[i] = new Semaphore(1);
    }
    for(int i = 0; i < red_blue.length; i++){
      red_blue[i] = new Semaphore(1);
    }
    for(int i = 0; i < gray_blue.length; i++){
      gray_blue[i] = new Semaphore(1);
    }
    for(int i = 0; i < black_blue.length; i++){
      black_blue[i] = new Semaphore(1);
    }
    for(int i = 0; i < blue_green.length; i++){
      blue_green[i] = new Semaphore(1);
    }
    for(int i = 0; i < orange_green.length; i++){
      orange_green[i] = new Semaphore(1);
    }
    for(int i = 0; i < aqua_green.length; i++){
      aqua_green[i] = new Semaphore(1);
    }
    for(int i = 0; i < purple_green.length; i++){
      purple_green[i] = new Semaphore(1);
    }
    for(int i = 0; i < red_green.length; i++){
      red_green[i] = new Semaphore(1);
    }
    for(int i = 0; i < black_green.length; i++){
      black_green[i] = new Semaphore(1);
    }
    for(int i = 0; i < gray_green.length; i++){
      gray_green[i] = new Semaphore(1);
    }
  }

  @FXML
  void pause_aqua_car(MouseEvent event) {
    if(!aqua_car.getIsPaused()){
      pause5.setImage(new Image("/resources/resume button.png"));
      aqua_car.setIsPaused(true);
    }
    else{
      pause5.setImage(new Image("/resources/pause button.png"));
      aqua_car.setIsPaused(false);
    }
  }

  @FXML
  void pause_black_car(MouseEvent event) {
    if(!black_car.getIsPaused()){
      pause1.setImage(new Image("/resources/resume button.png"));
      black_car.setIsPaused(true);
    }
    else{
      pause1.setImage(new Image("/resources/pause button.png"));
      black_car.setIsPaused(false);
    }
  }

  @FXML
  void pause_blue_car(MouseEvent event) {
    if(!blue_car.getIsPaused()){
      pause7.setImage(new Image("/resources/resume button.png"));
      blue_car.setIsPaused(true);
    }
    else{
      pause7.setImage(new Image("/resources/pause button.png"));
      blue_car.setIsPaused(false);
    }
  }

  @FXML
  void pause_gray_car(MouseEvent event) {
    if(!gray_car.getIsPaused()){
      pause2.setImage(new Image("/resources/resume button.png"));
      gray_car.setIsPaused(true);
    }
    else{
      pause2.setImage(new Image("/resources/pause button.png"));
      gray_car.setIsPaused(false);
    }
  }

  @FXML
  void pause_green_car(MouseEvent event) {
    if(!light_green_car.getIsPaused()){
      pause8.setImage(new Image("/resources/resume button.png"));
      light_green_car.setIsPaused(true);
    }
    else{
      pause8.setImage(new Image("/resources/pause button.png"));
      light_green_car.setIsPaused(false);
    }
  }

  @FXML
  void pause_orange_car(MouseEvent event) {
    if(!orange_car.getIsPaused()){
      pause6.setImage(new Image("/resources/resume button.png"));
      orange_car.setIsPaused(true);
    }
    else{
      pause6.setImage(new Image("/resources/pause button.png"));
      orange_car.setIsPaused(false);
    }
  }

  @FXML
  void pause_purple_car(MouseEvent event) {
    if(!purple_car.getIsPaused()){
      pause4.setImage(new Image("/resources/resume button.png"));
      purple_car.setIsPaused(true);
    }
    else{
      pause4.setImage(new Image("/resources/pause button.png"));
      purple_car.setIsPaused(false);
    }
  }

  @FXML
  void pause_red_car(MouseEvent event) {
    if(!red_car.getIsPaused()){
      pause3.setImage(new Image("/resources/resume button.png"));
      red_car.setIsPaused(true);
    }
    else{
      pause3.setImage(new Image("/resources/pause button.png"));
      red_car.setIsPaused(false);
    }
  }

  
  @FXML
  void show_aqua_route(MouseEvent event) {
    if(!aqua_car.getIsShowing()){
      aqua_car.setIsShowing(true);
      aqua_route.setVisible(true);
      aqua_route.toFront();
      bring_to_front();
    }
    else{
      aqua_car.setIsShowing(false);
      aqua_route.setVisible(false);
    }
  }

  @FXML
  void show_black_route(MouseEvent event) {
    if(!black_car.getIsShowing()){
      black_car.setIsShowing(true);
      black_route.setVisible(true);
      black_route.toFront();
      bring_to_front();
    }
    else{
      black_car.setIsShowing(false);
      black_route.setVisible(false);
    }
  }

  @FXML
  void show_blue_route(MouseEvent event) {
    if(!blue_car.getIsShowing()){
      blue_car.setIsShowing(true);
      blue_route.setVisible(true);
      blue_route.toFront();
      bring_to_front();
    }
    else{
      blue_car.setIsShowing(false);
      blue_route.setVisible(false);
    }
  }

  @FXML
  void show_gray_route(MouseEvent event) {
    if(!gray_car.getIsShowing()){
      gray_car.setIsShowing(true);
      gray_route.setVisible(true);
      gray_route.toFront();
      bring_to_front();
    }
    else{
      gray_car.setIsShowing(false);
      gray_route.setVisible(false);
    }
  }

  @FXML
  void show_green_route(MouseEvent event) {
    if(!light_green_car.getIsShowing()){
      light_green_car.setIsShowing(true);
      green_route.setVisible(true);
      green_route.toFront();
      bring_to_front();
    }
    else{
      light_green_car.setIsShowing(false);
      green_route.setVisible(false);
    }
  }

  @FXML
  void show_orange_route(MouseEvent event) {
    if(!orange_car.getIsShowing()){
      orange_car.setIsShowing(true);
      orange_route.setVisible(true);
      orange_route.toFront();
      bring_to_front();
    }
    else{
      orange_car.setIsShowing(false);
      orange_route.setVisible(false);
    }
  }

  @FXML
  void show_purple_route(MouseEvent event) {
    if(!purple_car.getIsShowing()){
      purple_car.setIsShowing(true);
      purple_route.setVisible(true);
      purple_route.toFront();
      bring_to_front();
    }
    else{
      purple_car.setIsShowing(false);
      purple_route.setVisible(false);
    }
  }

  @FXML
  void show_red_route(MouseEvent event) {
    if(!red_car.getIsShowing()){
      red_car.setIsShowing(true);
      red_route.setVisible(true);
      red_route.toFront();
      bring_to_front();
    }
    else{
      red_car.setIsShowing(false);
      red_route.setVisible(false);
    }
  }
  
  public void bring_to_front(){
    black_car_image.toFront();
    gray_car_image.toFront();
    red_car_image.toFront();
    purple_car_image.toFront();
    aqua_car_image.toFront();
    orange_car_image.toFront();
    blue_car_image.toFront();
    light_green_car_image.toFront();
    route_button1.toFront();
    route_button2.toFront();
    route_button3.toFront();
    route_button4.toFront();
    route_button5.toFront();
    route_button6.toFront();
    route_button7.toFront();
    route_button8.toFront();
    pause1.toFront();
    pause2.toFront();
    pause3.toFront();
    pause4.toFront();
    pause5.toFront();
    pause6.toFront();
    pause7.toFront();
    pause8.toFront();
    black_car_slider.toFront();
    gray_car_slider.toFront();
    red_car_slider.toFront();
    purple_car_slider.toFront();
    aqua_car_slider.toFront();
    orange_car_slider.toFront();
    blue_car_slider.toFront();
    light_green_car_slider.toFront();
    reset_button.toFront();
    close_button.toFront();
  }

  public void initialize_threads(){
    black_car = new Car(0, this, black_car_image, black_car_command_array, black_semaphores, black_car_slider);
    gray_car = new Car(1, this, gray_car_image, gray_car_command_array, gray_semaphores, gray_car_slider);
    red_car = new Car(2, this, red_car_image, red_car_command_array, red_semaphores, red_car_slider);
    purple_car = new Car(3, this, purple_car_image, purple_car_command_array, purple_semaphores, purple_car_slider);
    aqua_car = new Car(4, this, aqua_car_image, aqua_car_command_array, aqua_semaphores, aqua_car_slider);
    orange_car = new Car(5, this, orange_car_image, orange_car_command_array, orange_semaphores, orange_car_slider);
    blue_car = new Car(6, this, blue_car_image, blue_car_command_array, blue_semaphores, blue_car_slider);
    light_green_car = new Car(7, this, light_green_car_image, light_green_car_command_array, light_green_semaphores, light_green_car_slider);
    black_car.start();
    gray_car.start();
    red_car.start();
    purple_car.start();
    aqua_car.start();
    orange_car.start();
    blue_car.start();
    light_green_car.start();
  }

  @FXML
  void reset(MouseEvent event) {
    black_car_image.setLayoutX(black_car.initial_x);
    gray_car_image.setLayoutX(gray_car.initial_x);
    red_car_image.setLayoutX(red_car.initial_x);
    purple_car_image.setLayoutX(purple_car.initial_x);
    aqua_car_image.setLayoutX(aqua_car.initial_x);
    orange_car_image.setLayoutX(orange_car.initial_x);
    blue_car_image.setLayoutX(blue_car.initial_x);
    light_green_car_image.setLayoutX(light_green_car.initial_x);
    black_car_image.setLayoutY(black_car.initial_y);
    gray_car_image.setLayoutY(gray_car.initial_y);
    red_car_image.setLayoutY(red_car.initial_y);
    purple_car_image.setLayoutY(purple_car.initial_y);
    aqua_car_image.setLayoutY(aqua_car.initial_y);
    orange_car_image.setLayoutY(orange_car.initial_y);
    blue_car_image.setLayoutY(blue_car.initial_y);
    light_green_car_image.setLayoutY(light_green_car.initial_y);
    black_car_image.setRotate(black_car.initial_degree);
    gray_car_image.setRotate(gray_car.initial_degree);
    red_car_image.setRotate(red_car.initial_degree);
    purple_car_image.setRotate(purple_car.initial_degree);
    aqua_car_image.setRotate(aqua_car.initial_degree);
    orange_car_image.setRotate(orange_car.initial_degree);
    blue_car_image.setRotate(blue_car.initial_degree);
    light_green_car_image.setRotate(light_green_car.initial_degree);

    black_car.setReset(true);
    gray_car.setReset(true);
    red_car.setReset(true);
    purple_car.setReset(true);
    aqua_car.setReset(true);
    orange_car.setReset(true);
    blue_car.setReset(true);
    light_green_car.setReset(true);

    pause1.setImage(new Image("/resources/pause button.png"));
    pause2.setImage(new Image("/resources/pause button.png"));
    pause3.setImage(new Image("/resources/pause button.png"));
    pause4.setImage(new Image("/resources/pause button.png"));
    pause5.setImage(new Image("/resources/pause button.png"));
    pause6.setImage(new Image("/resources/pause button.png"));
    pause7.setImage(new Image("/resources/pause button.png"));
    pause8.setImage(new Image("/resources/pause button.png"));

    black_car_slider.setValue(5.5);
    gray_car_slider.setValue(5.5);
    red_car_slider.setValue(5.5);
    purple_car_slider.setValue(5.5);
    aqua_car_slider.setValue(5.5);
    orange_car_slider.setValue(5.5);
    blue_car_slider.setValue(5.5);
    light_green_car_slider.setValue(5.5);

    black_route.setVisible(false);
    gray_route.setVisible(false);
    red_route.setVisible(false);
    purple_route.setVisible(false);
    aqua_route.setVisible(false);
    orange_route.setVisible(false);
    blue_route.setVisible(false);
    green_route.setVisible(false);

    initialize_semaphores();
    initialize_threads();
  }

  @FXML
  void close(MouseEvent event) {
    System.exit(0);
  }

  @Override 
  public void initialize(URL arg0, ResourceBundle rb){
    //System.out.println();
    initialize_semaphores();
    initialize_threads();
  }   

}
