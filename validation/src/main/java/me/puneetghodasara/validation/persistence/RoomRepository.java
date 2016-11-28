package me.puneetghodasara.validation.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import me.puneetghodasara.validation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
