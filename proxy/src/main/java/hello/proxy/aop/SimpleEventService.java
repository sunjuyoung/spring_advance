package hello.proxy.aop;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService{

    @PerLogging
    @Override
    public void createEvent() {

        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Create Event");
    }
    @PerLogging
    @Override
    public void publishEvent() {
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("publish Event");
    }


    @Override
    public void deletedEvent(){
        System.out.println("delete event");
    }
}
