USE [master]
GO
/****** Object:  Database [PetCommunity1]    Script Date: 10/16/2023 12:13:39 AM ******/
CREATE DATABASE [PetCommunity1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PetCommunity1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PetCommunity1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PetCommunity1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PetCommunity1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PetCommunity1] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PetCommunity1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PetCommunity1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PetCommunity1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PetCommunity1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PetCommunity1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PetCommunity1] SET ARITHABORT OFF 
GO
ALTER DATABASE [PetCommunity1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PetCommunity1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PetCommunity1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PetCommunity1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PetCommunity1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PetCommunity1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PetCommunity1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PetCommunity1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PetCommunity1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PetCommunity1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PetCommunity1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PetCommunity1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PetCommunity1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PetCommunity1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PetCommunity1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PetCommunity1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PetCommunity1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PetCommunity1] SET RECOVERY FULL 
GO
ALTER DATABASE [PetCommunity1] SET  MULTI_USER 
GO
ALTER DATABASE [PetCommunity1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PetCommunity1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PetCommunity1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PetCommunity1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PetCommunity1] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'PetCommunity1', N'ON'
GO
ALTER DATABASE [PetCommunity1] SET QUERY_STORE = ON
GO
ALTER DATABASE [PetCommunity1] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO)
GO
USE [PetCommunity1]
GO
/****** Object:  Table [dbo].[blog_category]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[blog_category](
	[BlogCategoryID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nchar](10) NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_blog_category] PRIMARY KEY CLUSTERED 
(
	[BlogCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[blogs]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[blogs](
	[BlogID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[BlogContent] [nvarchar](50) NULL,
	[Image] [nvarchar](50) NULL,
	[DateCreate] [datetime] NULL,
	[DateUpdate] [datetime] NULL,
	[Status] [bit] NULL,
	[ReasonDeny] [nvarchar](50) NULL,
	[React] [nchar](10) NULL,
	[UserID] [int] NOT NULL,
	[BlogCategoryID] [int] NOT NULL,
 CONSTRAINT [PK_blogs] PRIMARY KEY CLUSTERED 
(
	[BlogID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[comments]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comments](
	[CommentID] [int] IDENTITY(1,1) NOT NULL,
	[DateCreate] [datetime] NULL,
	[DateUpdate] [datetime] NULL,
	[CommentContent] [nchar](10) NULL,
	[ReasonHiden] [nchar](10) NULL,
	[UserID] [int] NOT NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_comments] PRIMARY KEY CLUSTERED 
(
	[CommentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[item_categories]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[item_categories](
	[SubCategoryID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_item_categories] PRIMARY KEY CLUSTERED 
(
	[SubCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ItemExchange]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemExchange](
	[ItemExchange_ID] [int] NOT NULL,
	[ItemID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[ItemExchangeTitle] [nchar](50) NOT NULL,
 CONSTRAINT [PK_ItemExchange] PRIMARY KEY CLUSTERED 
(
	[ItemExchange_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[items]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[items](
	[ItemID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[Price] [float] NULL,
	[DateCreate] [datetime] NULL,
	[DateUpdate] [datetime] NULL,
	[Image] [nvarchar](50) NULL,
	[SubCategoryID] [int] NULL,
	[UserID] [int] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_items] PRIMARY KEY CLUSTERED 
(
	[ItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pet]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pet](
	[PetID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Age] [int] NULL,
	[Sex] [bit] NULL,
	[Weight] [float] NULL,
	[Height] [float] NULL,
	[Image] [nvarchar](50) NULL,
	[PetRaceID] [int] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_pet] PRIMARY KEY CLUSTERED 
(
	[PetID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pet_race]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pet_race](
	[PetRaceID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Breed] [nvarchar](50) NULL,
	[Image] [nvarchar](50) NULL,
 CONSTRAINT [PK_pet_race] PRIMARY KEY CLUSTERED 
(
	[PetRaceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PetExchange]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PetExchange](
	[PetExchangeID] [int] NOT NULL,
	[PetID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[PetExchangeTitle] [nchar](50) NULL,
 CONSTRAINT [PK_PetExchange] PRIMARY KEY CLUSTERED 
(
	[PetExchangeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[replies]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[replies](
	[ReplyID] [int] IDENTITY(1,1) NOT NULL,
	[DateCreate] [datetime] NULL,
	[DateUpdate] [datetime] NULL,
	[ReplyContent] [nchar](10) NULL,
	[ReasonHiden] [nchar](10) NULL,
	[CommentID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_replies] PRIMARY KEY CLUSTERED 
(
	[ReplyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[report]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[report](
	[ReportID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nchar](10) NULL,
	[Evident] [nchar](10) NULL,
	[ReportContent] [nchar](10) NULL,
	[DateCreate] [datetime] NULL,
	[DateResolve] [datetime] NULL,
	[ReasonDeny] [nchar](10) NULL,
	[BlogID] [int] NULL,
	[CommentID] [int] NULL,
	[ItemID] [int] NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_report] PRIMARY KEY CLUSTERED 
(
	[ReportID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RequestItemExchange]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RequestItemExchange](
	[ReItemExchange_ID] [int] NOT NULL,
	[ItemID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[ItemExchangeDate] [datetime] NOT NULL,
	[Note] [nchar](30) NULL,
	[Status] [bit] NOT NULL,
	[Location] [nchar](50) NOT NULL,
	[ItemExchange_ID] [int] NOT NULL,
 CONSTRAINT [PK_RequestItemExchange] PRIMARY KEY CLUSTERED 
(
	[ReItemExchange_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RequestPetExchange]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RequestPetExchange](
	[RePetExchangeID] [int] NOT NULL,
	[PetID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[PetExchangeDate] [datetime] NOT NULL,
	[Note] [nchar](30) NULL,
	[Status] [bit] NOT NULL,
	[Location] [nchar](50) NOT NULL,
	[PetExchangeID] [int] NOT NULL,
 CONSTRAINT [PK_RequestPetExchange] PRIMARY KEY CLUSTERED 
(
	[RePetExchangeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[RoleID] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_roles] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_accounts]    Script Date: 10/16/2023 12:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_accounts](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[Code] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Gmail] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[Phone] [nvarchar](20) NOT NULL,
	[Sex] [bit] NOT NULL,
	[DOB] [date] NOT NULL,
	[Image] [nvarchar](50) NOT NULL,
	[DateCreate] [datetime] NOT NULL,
	[DateUpdate] [datetime] NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
	[RoleID] [int] NOT NULL,
 CONSTRAINT [PK_user_accounts] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[blog_category] ON 

INSERT [dbo].[blog_category] ([BlogCategoryID], [Name], [Status]) VALUES (1, N'Info      ', 1)
INSERT [dbo].[blog_category] ([BlogCategoryID], [Name], [Status]) VALUES (2, N'Exchange  ', 1)
INSERT [dbo].[blog_category] ([BlogCategoryID], [Name], [Status]) VALUES (3, N'Health    ', 1)
SET IDENTITY_INSERT [dbo].[blog_category] OFF
SET IDENTITY_INSERT [dbo].[blogs] ON 

INSERT [dbo].[blogs] ([BlogID], [Title], [Description], [BlogContent], [Image], [DateCreate], [DateUpdate], [Status], [ReasonDeny], [React], [UserID], [BlogCategoryID]) VALUES (6, N'Chihuahua Healthcare', N'Chihuahua Healthcare', N'Details about how to better take care of Chihuahua', N'Img', CAST(N'2022-03-02T00:00:00.000' AS DateTime), CAST(N'2023-08-01T00:00:00.000' AS DateTime), 1, N'NONE', N'yes       ', 6, 3)
INSERT [dbo].[blogs] ([BlogID], [Title], [Description], [BlogContent], [Image], [DateCreate], [DateUpdate], [Status], [ReasonDeny], [React], [UserID], [BlogCategoryID]) VALUES (9, N'Cat Trivia ', N'Cat weird act', N'Cat''s weird act details', N'Img', CAST(N'2023-01-02T00:00:00.000' AS DateTime), CAST(N'2023-03-12T00:00:00.000' AS DateTime), 1, N'NONE', N'yes       ', 3, 1)
SET IDENTITY_INSERT [dbo].[blogs] OFF
SET IDENTITY_INSERT [dbo].[comments] ON 

INSERT [dbo].[comments] ([CommentID], [DateCreate], [DateUpdate], [CommentContent], [ReasonHiden], [UserID], [Status]) VALUES (1, CAST(N'2023-02-03T00:00:00.000' AS DateTime), CAST(N'2023-03-03T00:00:00.000' AS DateTime), N'Kinky Cat ', N'NONE      ', 6, 1)
SET IDENTITY_INSERT [dbo].[comments] OFF
SET IDENTITY_INSERT [dbo].[item_categories] ON 

INSERT [dbo].[item_categories] ([SubCategoryID], [Name], [Status]) VALUES (1, N'Pet Collar', 1)
INSERT [dbo].[item_categories] ([SubCategoryID], [Name], [Status]) VALUES (2, N'Pet Toy', 1)
INSERT [dbo].[item_categories] ([SubCategoryID], [Name], [Status]) VALUES (3, N'Pet Food', 1)
SET IDENTITY_INSERT [dbo].[item_categories] OFF
INSERT [dbo].[ItemExchange] ([ItemExchange_ID], [ItemID], [UserID], [ItemExchangeTitle]) VALUES (1, 1, 9, N'Good                                              ')
SET IDENTITY_INSERT [dbo].[items] ON 

INSERT [dbo].[items] ([ItemID], [Name], [Description], [Price], [DateCreate], [DateUpdate], [Image], [SubCategoryID], [UserID], [Status]) VALUES (1, N'Dog Collar', N'Pink color, Small size collar for dog', 70000, CAST(N'2022-12-20T00:00:00.000' AS DateTime), CAST(N'2023-02-21T00:00:00.000' AS DateTime), N'Collar', 1, 3, 1)
INSERT [dbo].[items] ([ItemID], [Name], [Description], [Price], [DateCreate], [DateUpdate], [Image], [SubCategoryID], [UserID], [Status]) VALUES (2, N'Speaky Bone', N'White bone toy for dog', 120000, CAST(N'2022-12-03T00:00:00.000' AS DateTime), CAST(N'2023-07-02T00:00:00.000' AS DateTime), N'T-Bone', 2, 6, 1)
SET IDENTITY_INSERT [dbo].[items] OFF
SET IDENTITY_INSERT [dbo].[pet] ON 

INSERT [dbo].[pet] ([PetID], [UserID], [Name], [Age], [Sex], [Weight], [Height], [Image], [PetRaceID], [Status]) VALUES (1, 3, N'Dark', 3, 1, 20, 90, N'TodoImg', 1, 1)
INSERT [dbo].[pet] ([PetID], [UserID], [Name], [Age], [Sex], [Weight], [Height], [Image], [PetRaceID], [Status]) VALUES (2, 6, N'Anu', 2, 0, 5, 20, N'AnuImg', 3, 1)
SET IDENTITY_INSERT [dbo].[pet] OFF
SET IDENTITY_INSERT [dbo].[pet_race] ON 

INSERT [dbo].[pet_race] ([PetRaceID], [Name], [Breed], [Image]) VALUES (1, N'Dog', N'German Shepherd', N'Bergie Dog')
INSERT [dbo].[pet_race] ([PetRaceID], [Name], [Breed], [Image]) VALUES (2, N'Dog', N'Chihuahua', N'Chihuahua Dog')
INSERT [dbo].[pet_race] ([PetRaceID], [Name], [Breed], [Image]) VALUES (3, N'Cat', N'Egypt Cat', N'Egypt Cat')
SET IDENTITY_INSERT [dbo].[pet_race] OFF
SET IDENTITY_INSERT [dbo].[replies] ON 

INSERT [dbo].[replies] ([ReplyID], [DateCreate], [DateUpdate], [ReplyContent], [ReasonHiden], [CommentID], [UserID], [Status]) VALUES (2, CAST(N'2023-02-10T00:00:00.000' AS DateTime), CAST(N'2023-03-10T00:00:00.000' AS DateTime), N'big dog   ', N'NONE      ', 1, 6, 1)
SET IDENTITY_INSERT [dbo].[replies] OFF
SET IDENTITY_INSERT [dbo].[report] ON 

INSERT [dbo].[report] ([ReportID], [Title], [Evident], [ReportContent], [DateCreate], [DateResolve], [ReasonDeny], [BlogID], [CommentID], [ItemID], [Status]) VALUES (5, N'RuleBreak ', N'Link      ', N'AnimalAB  ', CAST(N'2023-01-02T00:00:00.000' AS DateTime), CAST(N'2023-03-02T00:00:00.000' AS DateTime), N'NormalBl  ', 6, 1, NULL, 0)
SET IDENTITY_INSERT [dbo].[report] OFF
SET IDENTITY_INSERT [dbo].[roles] ON 

INSERT [dbo].[roles] ([RoleID], [RoleName]) VALUES (1, N'Staff')
INSERT [dbo].[roles] ([RoleID], [RoleName]) VALUES (2, N'Admin')
INSERT [dbo].[roles] ([RoleID], [RoleName]) VALUES (3, N'User')
SET IDENTITY_INSERT [dbo].[roles] OFF
SET IDENTITY_INSERT [dbo].[user_accounts] ON 

INSERT [dbo].[user_accounts] ([UserID], [Code], [Name], [Gmail], [Address], [Phone], [Sex], [DOB], [Image], [DateCreate], [DateUpdate], [Password], [Status], [RoleID]) VALUES (3, N'MA01', N'Nguyen Hoang Long', N'HLNguyen@gmail.com', N'90/09 Nguyen Van Qua, P12, Q.GoVap', N'0976532136', 1, CAST(N'1999-09-08' AS Date), N'ME', CAST(N'2022-09-12T00:00:00.000' AS DateTime), CAST(N'2023-10-01T00:00:00.000' AS DateTime), N'123', 1, 1)
INSERT [dbo].[user_accounts] ([UserID], [Code], [Name], [Gmail], [Address], [Phone], [Sex], [DOB], [Image], [DateCreate], [DateUpdate], [Password], [Status], [RoleID]) VALUES (6, N'AD01', N'Long Xuyen', N'Xlong@gmail.com', N'09/08 Nguyen Binh Khiem', N'0889976412', 0, CAST(N'2003-11-07' AS Date), N'Me', CAST(N'2023-02-07T00:00:00.000' AS DateTime), CAST(N'2023-06-07T00:00:00.000' AS DateTime), N'567', 1, 2)
INSERT [dbo].[user_accounts] ([UserID], [Code], [Name], [Gmail], [Address], [Phone], [Sex], [DOB], [Image], [DateCreate], [DateUpdate], [Password], [Status], [RoleID]) VALUES (9, N'US01', N'Nguyen Thanh Tan', N'NTTan@gmail.com', N'07/05 Ly Thai To', N'0133239887', 1, CAST(N'2002-09-08' AS Date), N'Tan Pic', CAST(N'2023-09-09T00:00:00.000' AS DateTime), CAST(N'2023-10-03T00:00:00.000' AS DateTime), N'789', 1, 3)
SET IDENTITY_INSERT [dbo].[user_accounts] OFF
/****** Object:  Index [IX_RequestPetExchange]    Script Date: 10/16/2023 12:13:39 AM ******/
CREATE NONCLUSTERED INDEX [IX_RequestPetExchange] ON [dbo].[RequestPetExchange]
(
	[RePetExchangeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[blogs]  WITH CHECK ADD  CONSTRAINT [FK_blogs_blog_category] FOREIGN KEY([BlogCategoryID])
REFERENCES [dbo].[blog_category] ([BlogCategoryID])
GO
ALTER TABLE [dbo].[blogs] CHECK CONSTRAINT [FK_blogs_blog_category]
GO
ALTER TABLE [dbo].[blogs]  WITH CHECK ADD  CONSTRAINT [FK_blogs_user_accounts] FOREIGN KEY([UserID])
REFERENCES [dbo].[user_accounts] ([UserID])
GO
ALTER TABLE [dbo].[blogs] CHECK CONSTRAINT [FK_blogs_user_accounts]
GO
ALTER TABLE [dbo].[comments]  WITH CHECK ADD  CONSTRAINT [FK_comments_user_accounts] FOREIGN KEY([UserID])
REFERENCES [dbo].[user_accounts] ([UserID])
GO
ALTER TABLE [dbo].[comments] CHECK CONSTRAINT [FK_comments_user_accounts]
GO
ALTER TABLE [dbo].[items]  WITH CHECK ADD  CONSTRAINT [FK_items_item_categories] FOREIGN KEY([SubCategoryID])
REFERENCES [dbo].[item_categories] ([SubCategoryID])
GO
ALTER TABLE [dbo].[items] CHECK CONSTRAINT [FK_items_item_categories]
GO
ALTER TABLE [dbo].[items]  WITH CHECK ADD  CONSTRAINT [FK_items_user_accounts] FOREIGN KEY([UserID])
REFERENCES [dbo].[user_accounts] ([UserID])
GO
ALTER TABLE [dbo].[items] CHECK CONSTRAINT [FK_items_user_accounts]
GO
ALTER TABLE [dbo].[pet]  WITH CHECK ADD  CONSTRAINT [FK_pet_pet_race] FOREIGN KEY([PetRaceID])
REFERENCES [dbo].[pet_race] ([PetRaceID])
GO
ALTER TABLE [dbo].[pet] CHECK CONSTRAINT [FK_pet_pet_race]
GO
ALTER TABLE [dbo].[pet]  WITH CHECK ADD  CONSTRAINT [FK_pet_user_accounts] FOREIGN KEY([UserID])
REFERENCES [dbo].[user_accounts] ([UserID])
GO
ALTER TABLE [dbo].[pet] CHECK CONSTRAINT [FK_pet_user_accounts]
GO
ALTER TABLE [dbo].[replies]  WITH CHECK ADD  CONSTRAINT [FK_replies_comments] FOREIGN KEY([CommentID])
REFERENCES [dbo].[comments] ([CommentID])
GO
ALTER TABLE [dbo].[replies] CHECK CONSTRAINT [FK_replies_comments]
GO
ALTER TABLE [dbo].[replies]  WITH CHECK ADD  CONSTRAINT [FK_replies_user_accounts] FOREIGN KEY([UserID])
REFERENCES [dbo].[user_accounts] ([UserID])
GO
ALTER TABLE [dbo].[replies] CHECK CONSTRAINT [FK_replies_user_accounts]
GO
ALTER TABLE [dbo].[report]  WITH CHECK ADD  CONSTRAINT [FK_report_blogs] FOREIGN KEY([BlogID])
REFERENCES [dbo].[blogs] ([BlogID])
GO
ALTER TABLE [dbo].[report] CHECK CONSTRAINT [FK_report_blogs]
GO
ALTER TABLE [dbo].[report]  WITH CHECK ADD  CONSTRAINT [FK_report_comments] FOREIGN KEY([CommentID])
REFERENCES [dbo].[comments] ([CommentID])
GO
ALTER TABLE [dbo].[report] CHECK CONSTRAINT [FK_report_comments]
GO
ALTER TABLE [dbo].[report]  WITH CHECK ADD  CONSTRAINT [FK_report_items] FOREIGN KEY([ItemID])
REFERENCES [dbo].[items] ([ItemID])
GO
ALTER TABLE [dbo].[report] CHECK CONSTRAINT [FK_report_items]
GO
ALTER TABLE [dbo].[RequestItemExchange]  WITH CHECK ADD  CONSTRAINT [FK_RequestItemExchange_ItemExchange] FOREIGN KEY([ItemExchange_ID])
REFERENCES [dbo].[ItemExchange] ([ItemExchange_ID])
GO
ALTER TABLE [dbo].[RequestItemExchange] CHECK CONSTRAINT [FK_RequestItemExchange_ItemExchange]
GO
ALTER TABLE [dbo].[RequestItemExchange]  WITH CHECK ADD  CONSTRAINT [FK_RequestItemExchange_items] FOREIGN KEY([ItemID])
REFERENCES [dbo].[items] ([ItemID])
GO
ALTER TABLE [dbo].[RequestItemExchange] CHECK CONSTRAINT [FK_RequestItemExchange_items]
GO
ALTER TABLE [dbo].[RequestItemExchange]  WITH CHECK ADD  CONSTRAINT [FK_RequestItemExchange_user_accounts] FOREIGN KEY([UserID])
REFERENCES [dbo].[user_accounts] ([UserID])
GO
ALTER TABLE [dbo].[RequestItemExchange] CHECK CONSTRAINT [FK_RequestItemExchange_user_accounts]
GO
ALTER TABLE [dbo].[RequestPetExchange]  WITH CHECK ADD  CONSTRAINT [FK_RequestPetExchange_pet] FOREIGN KEY([PetID])
REFERENCES [dbo].[pet] ([PetID])
GO
ALTER TABLE [dbo].[RequestPetExchange] CHECK CONSTRAINT [FK_RequestPetExchange_pet]
GO
ALTER TABLE [dbo].[RequestPetExchange]  WITH CHECK ADD  CONSTRAINT [FK_RequestPetExchange_PetExchange] FOREIGN KEY([PetExchangeID])
REFERENCES [dbo].[PetExchange] ([PetExchangeID])
GO
ALTER TABLE [dbo].[RequestPetExchange] CHECK CONSTRAINT [FK_RequestPetExchange_PetExchange]
GO
ALTER TABLE [dbo].[RequestPetExchange]  WITH CHECK ADD  CONSTRAINT [FK_RequestPetExchange_user_accounts] FOREIGN KEY([UserID])
REFERENCES [dbo].[user_accounts] ([UserID])
GO
ALTER TABLE [dbo].[RequestPetExchange] CHECK CONSTRAINT [FK_RequestPetExchange_user_accounts]
GO
ALTER TABLE [dbo].[user_accounts]  WITH CHECK ADD  CONSTRAINT [FK_user_accounts_roles] FOREIGN KEY([RoleID])
REFERENCES [dbo].[roles] ([RoleID])
GO
ALTER TABLE [dbo].[user_accounts] CHECK CONSTRAINT [FK_user_accounts_roles]
GO
USE [master]
GO
ALTER DATABASE [PetCommunity1] SET  READ_WRITE 
GO
