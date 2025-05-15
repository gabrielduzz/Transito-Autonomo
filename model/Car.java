/********************************************************************
* Autor: Gabriel dos Santos
* Inicio: 21/11/2023
* Ultima alteracao: 
* Nome: Car.java
* Funcao: Controla o movimento dos carros
********************************************************************/

package model;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import control.PrincipalController;
import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import java.lang.Math;

public class Car extends Thread {

  private ImageView car;
  private PrincipalController controller;
  private Slider slider;
  private String[] command_array;
  private int id;
  public double initial_x;
  public double initial_y;
  public double initial_degree;
  private Semaphore[][] semaphores;
  private ArrayList<Semaphore> to_release = new ArrayList<>();
  private String last_command;
  private boolean isPaused = false;
  private boolean isShowing = false;
  private boolean reset = false;

  public Car(int id, PrincipalController controller, ImageView car, String[] command_array, Semaphore[][] semaphores, Slider slider) {
    this.controller = controller;
    this.car = car;
    this.command_array = command_array;
    this.id = id;
    this.semaphores = semaphores;
    this.slider = slider;
  }

  public void setIsPaused(boolean isPaused){
    this.isPaused = isPaused;
  }

  public boolean getIsPaused(){
    return isPaused;
  }

  public void setIsShowing(boolean isShowing){
    this.isShowing = isShowing;
  }

  public void setReset(boolean reset){
    this.reset = reset;
  }

  public boolean getIsShowing(){
    return isShowing;
  }

  public int getSpeed() {
    double speedAux = slider.getValue();
    int speed = (int) speedAux;
    return speed * 2;
  }

  public void moveUp() {
    Platform.runLater(() -> car.setRotate(0));
    for (int i = 0; i < 60; i++) {
      while(isPaused && !reset){
        try{
          Thread.sleep(1);
        }
        catch(Exception e){
             
        }
      }
      if(reset){
        break;
      }
      Platform.runLater(() -> car.setLayoutY(car.getLayoutY() - 1));
      try {
        Thread.sleep(getSpeed());
      } catch (Exception e) {

      }
    }
  }

  public void moveDown() {
    Platform.runLater(() -> car.setRotate(180));
    for (int i = 0; i < 60; i++) {
      while(isPaused && !reset){
        try{
          Thread.sleep(1);
        }
        catch(Exception e){
             
        }
      }
      if(reset){
        break;
      }
      Platform.runLater(() -> car.setLayoutY(car.getLayoutY() + 1));
      try {
        Thread.sleep(getSpeed());
      } catch (Exception e) {

      }
    }
  }

  public void moveLeft() {
    Platform.runLater(() -> car.setRotate(270));
    for (int i = 0; i < 60; i++) {
      while(isPaused && !reset){
        try{
          Thread.sleep(1);
        }
        catch(Exception e){
             
        }
      }
      if(reset){
        break;
      }
      
      Platform.runLater(() -> car.setLayoutX(car.getLayoutX() - 1));
      try {
        Thread.sleep(getSpeed());
      } catch (Exception e) {

      }
    }
  }

  public void moveRight() {
    Platform.runLater(() -> car.setRotate(90));
    for (int i = 0; i < 60; i++) {
      while(isPaused && !reset){
        try{
          Thread.sleep(1);
        }
        catch(Exception e){
             
        }
      }
      if(reset){
        break;
      }
      Platform.runLater(() -> car.setLayoutX(car.getLayoutX() + 1));
      try {
        Thread.sleep(getSpeed());
      } catch (Exception e) {

      }
    }
  }

  public void move(String direction) {
    switch (direction) {
      case "up": {
        moveUp();
        break;
      }
      case "down": {
        moveDown();
        break;
      }
      case "left": {
        moveLeft();
        break;
      }
      case "right": {
        moveRight();
        break;
      }
      case "reset": {
        reset_position();
      }
    }
  }

  public void move_to_intersection(String direction) {
    switch (direction) {
      case "up": {
        for (int i = 0; i < 41; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutY(car.getLayoutY() - 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
      case "down": {
        for (int i = 0; i < 41; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutY(car.getLayoutY() + 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
      case "left": {
        for (int i = 0; i < 43; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutX(car.getLayoutX() - 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
      case "right": {
        for (int i = 0; i < 43; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutX(car.getLayoutX() + 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
    }
  }

  public void move_to_next_direction(String direction) {
    switch (direction) {
      case "up": {
        Platform.runLater(() -> car.setRotate(0));
        for (int i = 0; i < 34; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutY(car.getLayoutY() - 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
      case "down": {
        Platform.runLater(() -> car.setRotate(180));
        for (int i = 0; i < 34; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutY(car.getLayoutY() + 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
      case "left": {
        Platform.runLater(() -> car.setRotate(270));
        for (int i = 0; i < 34; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutX(car.getLayoutX() - 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
      case "right": {
        Platform.runLater(() -> car.setRotate(90));
        for (int i = 0; i < 34; i++) {
          while(isPaused && !reset){
            try{
              Thread.sleep(1);
            }
            catch(Exception e){
              
            }
          }
          if(reset){
            break;
          }
          Platform.runLater(() -> car.setLayoutX(car.getLayoutX() + 1));
          try {
            Thread.sleep(getSpeed());
          } catch (Exception e) {

          }
        }
        break;
      }
      case "reset":{
        reset_position();
        break;
      }
    }
  }

  public void reset_position() {
    double coordX = car.getLayoutX() - initial_x;
    double coordY = car.getLayoutY() - initial_y;
    Platform.runLater(() -> car.setRotate(initial_degree));
    if (coordX > 0) {
      for (int i = 0; i < Math.abs((int) coordX); i++) {
        while(isPaused && !reset){
          try{
            Thread.sleep(1);
          }
          catch(Exception e){
            
          }
        }
        if(reset){
          break;
        }
        Platform.runLater(() -> car.setLayoutX(car.getLayoutX() - 1));
        try {
          Thread.sleep(getSpeed());
        } catch (Exception e) {

        }
      }
    } else {
      for (int i = 0; i < Math.abs((int) coordX); i++) {
        while(isPaused && !reset){
          try{
            Thread.sleep(1);
          }
          catch(Exception e){
            
          }
        }
        if(reset){
          break;
        }
        Platform.runLater(() -> car.setLayoutX(car.getLayoutX() + 1));
        try {
          Thread.sleep(getSpeed());
        } catch (Exception e) {

        }
      }
    } 
    if (coordY > 0) {
      for (int i = 0; i < Math.abs((int) coordY); i++) {
        while(isPaused && !reset){
          try{
            Thread.sleep(1);
          }
          catch(Exception e){
            
          }
        }
        if(reset){
          break;
        }
        Platform.runLater(() -> car.setLayoutY(car.getLayoutY() - 1));
        try {
          Thread.sleep(getSpeed());
        } catch (Exception e) {

        }
      }
    } else {
      for (int i = 0; i < Math.abs((int) coordY); i++) {
        while(isPaused && !reset){
          try{
            Thread.sleep(1);
          }
          catch(Exception e){
            
          }
        }
        if(reset){
          break;
        }
        Platform.runLater(() -> car.setLayoutY(car.getLayoutY() + 1));
        try {
          Thread.sleep(getSpeed());
        } catch (Exception e) {

        }
      }
    }

  }

  public void travel_route() {
    try {
      for (int i = 0; i < command_array.length; i++) {
        //System.out.println(id + " " + i);
        String command = command_array[i];

        while(isPaused && !reset){
          Thread.sleep(1);
        }
        if(reset){
          break;
        }

        if (command.charAt(0) != '+' && command.charAt(0) != '-') {
          move(command);
          last_command = command;
        }

        if (command.charAt(0) == '-') {
          int sem_idx = command.charAt(2) - '0';
          int critical_region_idx = command.charAt(4) - '0';
          Semaphore sem = semaphores[sem_idx][critical_region_idx];
          //System.out.println(id + " " + command);
          sem.acquire();
        }

        while(isPaused && !reset){
          Thread.sleep(1);
        }
        if(reset){
          break;
        }

        if(i < command_array.length - 1){
          if (command_array[i+1].charAt(0) != '-' && command_array[i+1].charAt(0) != '+') {
            move_to_intersection(last_command);
            String next_direction = "";
            for (int j = i+1; i < command_array.length; i++) {
              if (command_array[j].charAt(0) != '+' && command_array[j].charAt(0) != '-') {
                next_direction = command_array[j];
                break;
              }
            }
            if(next_direction == "reset"){
              reset_position();
            }
            else{
              move_to_next_direction(next_direction);
            }
            if (to_release.size() > 0) {
              for (int k = 0; k < to_release.size(); k++) {
                to_release.get(k).release();
              }
              to_release.clear();
            }
          }
        }  

        while(isPaused && !reset){
          Thread.sleep(1);
        }
        if(reset){
          break;
        }

        if (command.charAt(0) == '+') {
          int sem_idx = command.charAt(2) - '0';
          int critical_region_idx = command.charAt(4) - '0';
          Semaphore sem = semaphores[sem_idx][critical_region_idx];
          if (command_array[i + 1].charAt(0) != '+') {
            sem.release();
          } else {
            to_release.add(sem);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(id);
    }

  }

  public void run() {
    initial_degree = car.getRotate();
    initial_x = car.getLayoutX();
    initial_y = car.getLayoutY();
    while (true) {
      try {
        travel_route();
      } catch (Exception e) {

      }
      if(reset){
        break;
      }
    }

  }

}
