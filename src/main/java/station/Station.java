package station;

import fileInput.BasicInput;

public class Station {

        private String name;
        public Station(BasicInput input){

        }
        public Station(){

        }
        public Station(String name){
                this.name = name;
        }

        @Override
        public String toString(){
                return name;
        }

}
