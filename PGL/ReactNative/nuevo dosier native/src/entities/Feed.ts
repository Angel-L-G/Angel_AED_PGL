import { BaseEntity, Column, Entity, OneToMany, PrimaryGeneratedColumn } from "typeorm";
import { FeedItem } from "./FeedItem";

@Entity()
export class Feed extends BaseEntity{
    @PrimaryGeneratedColumn() id: number;
    @Column("title") titulo: string;
    @Column("url") url: string;
    @OneToMany( ()=> FeedItem, (feedItem)=>feedItem.id)
    feedItems: FeedItem[];
}