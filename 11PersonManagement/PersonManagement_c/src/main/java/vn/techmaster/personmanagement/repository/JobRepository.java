package vn.techmaster.personmanagement.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.personmanagement.model.Job;
import vn.techmaster.personmanagement.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
//Tao repository luu tru va thao tac cho Job
public class JobRepository {
    private List<Job> jobs = new ArrayList<>();
    public JobRepository(){
        List<Job> listJobs = Arrays.asList(
          new Job(1,"Developer"),
          new Job(2,"Actor"),
          new Job(3,"Singer"),
          new Job(4,"Taxi driver")
        );
        listJobs.forEach(job->jobs.add(job));
    }

    public List<Job> getAll() {
        return jobs;
    }

    //Them job
    public Job create(Job job){
        int id;
        if (jobs.isEmpty()) {
            id = 1;
        } else {
            Job lastJob = jobs.get(jobs.size() - 1);
            id = lastJob.getId() + 1;
        }
        job.setId(id);
        for(Job j:jobs){
            if(job.getName().equalsIgnoreCase(j.getName()))
                return null;
        }
        jobs.add(job);
        return job;
    }

    //Cap nhat job
    public Job edit(Job job){
        get(job.getId()).ifPresent(existJob->{
            existJob.setName(job.getName());
        });
        return job;
    }

    //Xoa job
    public void delete(Person person){
        deleteById(person.getId());
    }

    public Optional<Job> get(int id) {
        return jobs.stream().filter(j -> j.getId() == id).findFirst();
    }

    public void deleteById(int id) {
        get(id).ifPresent(existed -> jobs.remove(existed));
    }
}
