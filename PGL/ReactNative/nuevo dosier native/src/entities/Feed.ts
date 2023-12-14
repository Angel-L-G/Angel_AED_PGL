import { BaseEntity, Column, Entity, OneToMany, PrimaryGeneratedColumn } from "typeorm";
import { FeedItem } from "./FeedItem";

@Entity("Feed")
export class Feed extends BaseEntity{
    @PrimaryGeneratedColumn("increment") id: number;
    @Column("text") titulo: string;
    @Column("text") url: string;
    @OneToMany( ()=> FeedItem, (feedItem)=>feedItem.feed)
    feedItems: FeedItem[];
}