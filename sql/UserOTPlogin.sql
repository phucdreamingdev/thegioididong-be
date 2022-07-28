USE [master]
GO
/****** Object:  Database [tgdd]    Script Date: 7/28/2022 2:43:24 PM ******/
CREATE DATABASE [tgdd]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'tgdd', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\tgdd.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'tgdd_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\tgdd_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [tgdd] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [tgdd].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [tgdd] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [tgdd] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [tgdd] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [tgdd] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [tgdd] SET ARITHABORT OFF 
GO
ALTER DATABASE [tgdd] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [tgdd] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [tgdd] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [tgdd] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [tgdd] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [tgdd] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [tgdd] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [tgdd] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [tgdd] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [tgdd] SET  DISABLE_BROKER 
GO
ALTER DATABASE [tgdd] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [tgdd] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [tgdd] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [tgdd] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [tgdd] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [tgdd] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [tgdd] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [tgdd] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [tgdd] SET  MULTI_USER 
GO
ALTER DATABASE [tgdd] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [tgdd] SET DB_CHAINING OFF 
GO
ALTER DATABASE [tgdd] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [tgdd] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [tgdd] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [tgdd] SET QUERY_STORE = OFF
GO
USE [tgdd]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [tgdd]
GO
/****** Object:  Table [dbo].[admin_account]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin_account](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](100) NULL,
	[password] [varchar](255) NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[branch]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[branch](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[address_detail] [nvarchar](200) NULL,
	[status] [bit] NULL,
	[ward_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[branch_stock]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[branch_stock](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[stock] [int] NULL,
	[branch_id] [bigint] NULL,
	[version_color_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[children_level] [int] NULL,
	[is_parent] [bit] NULL,
	[level] [int] NULL,
	[logo] [varchar](255) NULL,
	[name] [nvarchar](100) NULL,
	[parent_name] [nvarchar](100) NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[color]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[color](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[manufacturer_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[district]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[district](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[province_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[url] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image_detail]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image_detail](
	[image_id] [bigint] NOT NULL,
	[image_group_version_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[image_id] ASC,
	[image_group_version_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image_group]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image_group](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[category_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image_group_version]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image_group_version](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[detail] [nvarchar](200) NULL,
	[image_group_id] [bigint] NULL,
	[version_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[image_product]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image_product](
	[image_id] [bigint] NOT NULL,
	[version_color_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[image_id] ASC,
	[version_color_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[manufacturer]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[manufacturer](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[description] [varchar](255) NULL,
	[logo_url] [varchar](255) NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[manufacturer_category]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[manufacturer_category](
	[manufacturer_id] [bigint] NOT NULL,
	[category_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[manufacturer_id] ASC,
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[phone] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member_address]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member_address](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[address_detail] [nvarchar](200) NULL,
	[is_default] [bit] NULL,
	[member_id] [bigint] NULL,
	[ward_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member_order]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member_order](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[delivery_date] [datetime2](7) NULL,
	[delivery_status] [varchar](255) NULL,
	[note] [nvarchar](200) NULL,
	[order_date] [datetime2](7) NULL,
	[recieve_date] [datetime2](7) NULL,
	[total_payment] [float] NULL,
	[branch_id] [bigint] NULL,
	[member_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_detail]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_detail](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[original_price] [float] NULL,
	[promotion_price] [float] NULL,
	[quantity] [int] NULL,
	[member_order_id] [bigint] NULL,
	[version_color_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[is_actived] [bit] NULL,
	[name] [nvarchar](100) NULL,
	[category_id] [bigint] NULL,
	[manufacturer_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[promotion]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[promotion](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[end_date] [datetime2](7) NULL,
	[promotion_percent] [int] NULL,
	[start_date] [datetime2](7) NULL,
	[version_color_id] [bigint] NULL,
	[is_actived] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[promotion_branch]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[promotion_branch](
	[promotion_id] [bigint] NOT NULL,
	[branch_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[promotion_id] ASC,
	[branch_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[promotion_province]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[promotion_province](
	[promotion_id] [bigint] NOT NULL,
	[province_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[promotion_id] ASC,
	[province_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[promotion_verion_color]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[promotion_verion_color](
	[promotion_id] [bigint] NOT NULL,
	[version_color_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[promotion_id] ASC,
	[version_color_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[province]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[province](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[specification]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[specification](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[image_id] [bigint] NULL,
	[version_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[specification_detail]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[specification_detail](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [varchar](255) NULL,
	[name] [nvarchar](100) NULL,
	[specification_id] [bigint] NULL,
	[specification_group_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[specification_group]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[specification_group](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[category_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transaction_branch]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transaction_branch](
	[transaciton_id] [bigint] NOT NULL,
	[branch_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[transaciton_id] ASC,
	[branch_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transaction_detail]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transaction_detail](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[in_stock] [bit] NULL,
	[note] [nvarchar](200) NULL,
	[stock] [int] NULL,
	[transaction_date] [datetime2](7) NULL,
	[transaction_quantity] [int] NULL,
	[transaction_id] [bigint] NULL,
	[version_color_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transactions]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transactions](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[detail] [varchar](255) NULL,
	[total] [int] NULL,
	[transaction_date] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[version]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[version](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
	[video_url] [varchar](255) NULL,
	[product_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[version_color]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[version_color](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[avartar] [varchar](255) NULL,
	[is_default] [bit] NULL,
	[name] [nvarchar](100) NULL,
	[price] [float] NULL,
	[color_id] [bigint] NULL,
	[version_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ward]    Script Date: 7/28/2022 2:43:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ward](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[district_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[branch] ON 

INSERT [dbo].[branch] ([id], [address_detail], [status], [ward_id]) VALUES (2, N'Ho Chi Minh', 1, 2)
SET IDENTITY_INSERT [dbo].[branch] OFF
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (1, 0, 0, 0, N'cdn.tgdd.vn/content/icon-phone-96x96-2.png', N'Điện Thoại', N'', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (2, 0, 0, 0, N'cdn.tgdd.vn/content/icon-laptop-96x96-1.png', N'Laptop', N'', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (3, 0, 0, 0, N'cdn.tgdd.vn/content/icon-tablet-96x96-1.png', N'Tablet', N'', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (4, 1, 1, 0, N'cdn.tgdd.vn/content/icon-phu-kien-96x96-1.png', N'Phụ Kiện', N'', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (5, 0, 0, 0, N'cdn.tgdd.vn/content/icon-smartwatch-96x96-1.png', N'Smartwatch', N'', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (6, 0, 0, 0, N'cdn.tgdd.vn/content/watch-icon-96x96.png', N'Đồng Hồ', N'', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (7, 2, 1, 0, N'cdn.tgdd.vn/content/icon-pc-96x96.png', N'PC, Máy in', N'', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (8, 2, 1, 1, N'', N'PHỤ KIỆN DI ĐỘNG', N'Phụ Kiện', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (9, 2, 1, 1, N'', N'PHỤ KIỆN LAPTOP', N'Phụ Kiện', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (10, 2, 1, 1, N'', N'THIẾT BỊ ÂM THANH', N'Phụ Kiện', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (11, 2, 1, 1, N'', N'THIẾT BỊ NHÀ THÔNG MINH', N'Phụ Kiện', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (12, 2, 1, 1, N'', N'THIẾT BỊ LƯU TRỮ', N'Phụ Kiện', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (13, 2, 1, 1, N'', N'PHỤ KIỆN KHÁC', N'Phụ Kiện', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (14, 2, 0, 2, N'', N'Sạc dự phòng', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (15, 2, 0, 2, N'', N'Sạc, cáp', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (16, 2, 0, 2, N'', N'Ốp lưng điện thoại', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (17, 2, 0, 2, N'', N'Ốp lưng máy tính', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (18, 2, 0, 2, N'', N'Miếng dán màn hình', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (19, 2, 0, 2, N'', N'Gậy chụp ảnh, gimbal', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (20, 2, 0, 2, N'', N'Giá đỡ điện thoại', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (21, 2, 0, 2, N'', N'Đế, móc điện thoại', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (22, 2, 0, 2, N'', N'Túi chống nước', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (23, 2, 0, 2, N'', N'Túi đựng AirPods', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (24, 2, 0, 2, N'', N'AirTag', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (25, 2, 0, 2, N'', N'Phụ kiện Tablet', N'PHỤ KIỆN DI ĐỘNG', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (26, 2, 0, 2, N'', N'Chuột, bàn phím', N'PHỤ KIỆN LAPTOP', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (27, 2, 0, 2, N'', N'Thiết bị mạng', N'PHỤ KIỆN LAPTOP', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (28, 2, 0, 2, N'', N'Camera, webcam', N'PHỤ KIỆN LAPTOP', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (29, 2, 0, 2, N'', N'Balo, túi chống sốc', N'PHỤ KIỆN LAPTOP', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (30, 2, 0, 2, N'', N'Giá đỡ laptop', N'PHỤ KIỆN LAPTOP', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (31, 2, 0, 2, N'', N'Phần mềm', N'PHỤ KIỆN LAPTOP', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (32, 2, 0, 2, N'', N'Tai Nghe', N'THIẾT BỊ ÂM THANH', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (33, 2, 0, 2, N'', N'Loa', N'THIẾT BỊ ÂM THANH', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (34, 2, 0, 2, N'', N'Khoá Điện Tử', N'THIẾT BỊ NHÀ THÔNG MINH', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (35, 2, 0, 2, N'', N'TV Box', N'THIẾT BỊ NHÀ THÔNG MINH', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (36, 2, 0, 2, N'', N'Ổ cứng, bóng đèn thông minh', N'THIẾT BỊ NHÀ THÔNG MINH', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (37, 2, 0, 2, N'', N'Máy chiếu', N'THIẾT BỊ NHÀ THÔNG MINH', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (38, 2, 0, 2, N'', N'Ổ cứng di động', N'THIẾT BỊ LƯU TRỮ', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (39, 2, 0, 2, N'', N'Thẻ nhớ', N'THIẾT BỊ LƯU TRỮ', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (40, 2, 0, 2, N'', N'USB', N'THIẾT BỊ LƯU TRỮ', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (41, 2, 0, 2, N'', N'Phụ Kiện ô tô', N'PHỤ KIỆN KHÁC', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (42, 2, 0, 2, N'', N'Máy tính cầm tay', N'PHỤ KIỆN KHÁC', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (43, 2, 0, 2, N'', N'Quạt mini', N'PHỤ KIỆN KHÁC', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (44, 2, 0, 2, N'', N'Pin Tiểu', N'PHỤ KIỆN KHÁC', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (45, 2, 0, 2, N'', N'Máy in', N'PC, Máy in', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (46, 2, 0, 2, N'', N'Mực in', N'PC, Máy in', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (47, 2, 0, 2, N'', N'Màn hình máy tính', N'PC, Máy in', 1)
INSERT [dbo].[category] ([id], [children_level], [is_parent], [level], [logo], [name], [parent_name], [status]) VALUES (48, 2, 0, 2, N'', N'Máy tính để bàn', N'PC, Máy in', 1)
SET IDENTITY_INSERT [dbo].[category] OFF
GO
SET IDENTITY_INSERT [dbo].[color] ON 

INSERT [dbo].[color] ([id], [name], [manufacturer_id]) VALUES (1, N'Tr?ng', 1)
INSERT [dbo].[color] ([id], [name], [manufacturer_id]) VALUES (2, N'Xanh duong', 1)
INSERT [dbo].[color] ([id], [name], [manufacturer_id]) VALUES (3, N'H?ng', 1)
INSERT [dbo].[color] ([id], [name], [manufacturer_id]) VALUES (4, N'Ðen', 1)
INSERT [dbo].[color] ([id], [name], [manufacturer_id]) VALUES (5, N'Xanh lá', 1)
INSERT [dbo].[color] ([id], [name], [manufacturer_id]) VALUES (6, N'Ð?', 1)
SET IDENTITY_INSERT [dbo].[color] OFF
GO
SET IDENTITY_INSERT [dbo].[district] ON 

INSERT [dbo].[district] ([id], [name], [province_id]) VALUES (5, N'Quan 1', 1)
SET IDENTITY_INSERT [dbo].[district] OFF
GO
SET IDENTITY_INSERT [dbo].[manufacturer] ON 

INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (1, N'', N'cdn.tgdd.vn/Brand/1/logo-iphone-220x48.png', N'Iphone')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (2, N'', N'cdn.tgdd.vn/Brand/1/samsungnew-220x48-1.png', N'SamSung')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (3, N'', N'cdn.tgdd.vn/Brand/1/OPPO42-b_5.jpg', N'OPPO')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (4, N'', N'cdn.tgdd.vn/Brand/1/logo-xiaomi-220x48-5.png', N'Xiaomi')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (5, N'', N'cdn.tgdd.vn/Brand/1/vivo-logo-220-220x48-3.png', N'Vivo')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (6, N'', N'cdn.tgdd.vn/Brand/1/Realme42-b_37.png', N'Realme')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (7, N'', N'cdn.tgdd.vn/Brand/1/Nokia42-b_21.jpg', N'Nokia')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (8, N'', N'cdn.tgdd.vn/Brand/1/Mobell42-b_19.jpg', N'Mobell')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (9, N'', N'cdn.tgdd.vn/Brand/1/Itel42-b_54.jpg', N'Itel')
INSERT [dbo].[manufacturer] ([id], [description], [logo_url], [name]) VALUES (10, N'', N'cdn.tgdd.vn/Brand/1/Masstel42-b_0.png', N'Masstel')
SET IDENTITY_INSERT [dbo].[manufacturer] OFF
GO
SET IDENTITY_INSERT [dbo].[member] ON 

INSERT [dbo].[member] ([id], [fullname], [gender], [phone]) VALUES (1, N'Long', 1, N'+84865604540')
INSERT [dbo].[member] ([id], [fullname], [gender], [phone]) VALUES (2, N'Minh', 1, N'+84867635674')
SET IDENTITY_INSERT [dbo].[member] OFF
GO
SET IDENTITY_INSERT [dbo].[member_address] ON 

INSERT [dbo].[member_address] ([id], [address_detail], [is_default], [member_id], [ward_id]) VALUES (1, N'beautifull place', 1, 1, 2)
SET IDENTITY_INSERT [dbo].[member_address] OFF
GO
SET IDENTITY_INSERT [dbo].[member_order] ON 

INSERT [dbo].[member_order] ([id], [delivery_date], [delivery_status], [note], [order_date], [recieve_date], [total_payment], [branch_id], [member_id]) VALUES (6, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'DELIVERED', N'giao nhanh cho bo may', CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), CAST(N'2022-07-27T00:00:00.0000000' AS DateTime2), 500000, 2, 1)
INSERT [dbo].[member_order] ([id], [delivery_date], [delivery_status], [note], [order_date], [recieve_date], [total_payment], [branch_id], [member_id]) VALUES (7, CAST(N'2022-05-25T00:00:00.0000000' AS DateTime2), N'DELIVERED', N'buda', CAST(N'2022-05-24T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-27T00:00:00.0000000' AS DateTime2), 3000, 2, 2)
SET IDENTITY_INSERT [dbo].[member_order] OFF
GO
SET IDENTITY_INSERT [dbo].[order_detail] ON 

INSERT [dbo].[order_detail] ([id], [original_price], [promotion_price], [quantity], [member_order_id], [version_color_id]) VALUES (1, 1000000, 500000, 1, 6, 1)
INSERT [dbo].[order_detail] ([id], [original_price], [promotion_price], [quantity], [member_order_id], [version_color_id]) VALUES (2, 1000000, 500000, 1, 6, 2)
INSERT [dbo].[order_detail] ([id], [original_price], [promotion_price], [quantity], [member_order_id], [version_color_id]) VALUES (3, 300, 10, 1, 7, 2)
SET IDENTITY_INSERT [dbo].[order_detail] OFF
GO
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [is_actived], [name], [category_id], [manufacturer_id]) VALUES (1, 1, N'iPhone 13', 1, 1)
SET IDENTITY_INSERT [dbo].[product] OFF
GO
SET IDENTITY_INSERT [dbo].[province] ON 

INSERT [dbo].[province] ([id], [name]) VALUES (1, N'Tp.H? Chí Minh')
SET IDENTITY_INSERT [dbo].[province] OFF
GO
SET IDENTITY_INSERT [dbo].[version] ON 

INSERT [dbo].[version] ([id], [name], [video_url], [product_id]) VALUES (1, N'128GB', N'', 1)
INSERT [dbo].[version] ([id], [name], [video_url], [product_id]) VALUES (2, N'256GB', N'', 1)
INSERT [dbo].[version] ([id], [name], [video_url], [product_id]) VALUES (3, N'512GB', N'', 1)
SET IDENTITY_INSERT [dbo].[version] OFF
GO
SET IDENTITY_INSERT [dbo].[version_color] ON 

INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (1, N'https://cdn.tgdd.vn/Products/Images/42/223602/TimerThumb/iphone-13-(4).jpg', 1, N'Điện thoại iPhone 13 128GB  ', 2499000, 1, 1)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (2, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-blue-1-200x200.jpg', 0, N'Điện thoại iPhone 13 128GB  ', 2499000, 2, 1)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (3, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg', 0, N'Điện thoại iPhone 13 128GB  ', 2499000, 3, 1)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (4, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-midnight-2-200x200.jpg', 0, N'Điện thoại iPhone 13 128GB  ', 2499000, 4, 1)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (5, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-xanh-la-thumb-new-200x200.jpg', 0, N'Điện thoại iPhone 13 128GB  ', 2499000, 5, 1)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (6, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg', 0, N'Điện thoại iPhone 13 128GB  ', 2499000, 6, 1)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (7, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-200x200.jpg', 0, N'Điện thoại iPhone 13 256GB  ', 2799000, 1, 2)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (8, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-blue-1-200x200.jpg', 0, N'Điện thoại iPhone 13 256GB  ', 2799000, 2, 2)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (9, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg', 0, N'Điện thoại iPhone 13 256GB  ', 2799000, 3, 2)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (10, N'https://cdn.tgdd.vn/Products/Images/42/250258/iphone-13-midnight-1-600x600.jpg', 1, N'Điện thoại iPhone 13 256GB  ', 2799000, 4, 2)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (11, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-xanh-la-thumb-new-200x200.jpg', 0, N'Điện thoại iPhone 13 256GB  ', 2799000, 5, 2)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (12, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg', 0, N'Điện thoại iPhone 13 256GB  ', 2799000, 6, 2)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (13, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-200x200.jpg', 0, N'Điện thoại iPhone 13 512GB', 32490000, 1, 3)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (14, N'https://cdn.tgdd.vn/Products/Images/42/250257/iphone-13-blue-1-600x600.jpg', 1, N'Điện thoại iPhone 13 512GB', 32490000, 2, 3)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (15, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg', 0, N'Điện thoại iPhone 13 512GB', 32490000, 3, 3)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (16, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-midnight-2-200x200.jpg', 0, N'Điện thoại iPhone 13 512GB', 32490000, 4, 3)
INSERT [dbo].[version_color] ([id], [avartar], [is_default], [name], [price], [color_id], [version_id]) VALUES (17, N'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg', 0, N'Điện thoại iPhone 13 512GB  ', 32490000, 6, 3)
SET IDENTITY_INSERT [dbo].[version_color] OFF
GO
SET IDENTITY_INSERT [dbo].[ward] ON 

INSERT [dbo].[ward] ([id], [name], [district_id]) VALUES (2, N'Phu?ng 7', 5)
SET IDENTITY_INSERT [dbo].[ward] OFF
GO
ALTER TABLE [dbo].[branch]  WITH CHECK ADD  CONSTRAINT [FKmvc4u4gdbj4hfou9ukgrdljib] FOREIGN KEY([ward_id])
REFERENCES [dbo].[ward] ([id])
GO
ALTER TABLE [dbo].[branch] CHECK CONSTRAINT [FKmvc4u4gdbj4hfou9ukgrdljib]
GO
ALTER TABLE [dbo].[branch_stock]  WITH CHECK ADD  CONSTRAINT [FKenr9fxn47c1wkxj9l33brnhtv] FOREIGN KEY([branch_id])
REFERENCES [dbo].[branch] ([id])
GO
ALTER TABLE [dbo].[branch_stock] CHECK CONSTRAINT [FKenr9fxn47c1wkxj9l33brnhtv]
GO
ALTER TABLE [dbo].[branch_stock]  WITH CHECK ADD  CONSTRAINT [FKs5uuutnqml966mh1k1johcfx3] FOREIGN KEY([version_color_id])
REFERENCES [dbo].[version_color] ([id])
GO
ALTER TABLE [dbo].[branch_stock] CHECK CONSTRAINT [FKs5uuutnqml966mh1k1johcfx3]
GO
ALTER TABLE [dbo].[color]  WITH CHECK ADD  CONSTRAINT [FKfka4dhvvwiidmvpcd4u7nqt6i] FOREIGN KEY([manufacturer_id])
REFERENCES [dbo].[manufacturer] ([id])
GO
ALTER TABLE [dbo].[color] CHECK CONSTRAINT [FKfka4dhvvwiidmvpcd4u7nqt6i]
GO
ALTER TABLE [dbo].[district]  WITH CHECK ADD  CONSTRAINT [FK276utu38g5lgqeth6pwfm3rw2] FOREIGN KEY([province_id])
REFERENCES [dbo].[province] ([id])
GO
ALTER TABLE [dbo].[district] CHECK CONSTRAINT [FK276utu38g5lgqeth6pwfm3rw2]
GO
ALTER TABLE [dbo].[image_detail]  WITH CHECK ADD  CONSTRAINT [FKb90jrsa2w3w4e32bdyjytycir] FOREIGN KEY([image_id])
REFERENCES [dbo].[image] ([id])
GO
ALTER TABLE [dbo].[image_detail] CHECK CONSTRAINT [FKb90jrsa2w3w4e32bdyjytycir]
GO
ALTER TABLE [dbo].[image_detail]  WITH CHECK ADD  CONSTRAINT [FKkdjhxronhrb4i5uusvr0hav8m] FOREIGN KEY([image_group_version_id])
REFERENCES [dbo].[image_group_version] ([id])
GO
ALTER TABLE [dbo].[image_detail] CHECK CONSTRAINT [FKkdjhxronhrb4i5uusvr0hav8m]
GO
ALTER TABLE [dbo].[image_group]  WITH CHECK ADD  CONSTRAINT [FK3oghaimofps5k3ncnmco4sv6g] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[image_group] CHECK CONSTRAINT [FK3oghaimofps5k3ncnmco4sv6g]
GO
ALTER TABLE [dbo].[image_group_version]  WITH CHECK ADD  CONSTRAINT [FK153j6ek1mlqxkymq038oa5u2q] FOREIGN KEY([version_id])
REFERENCES [dbo].[version] ([id])
GO
ALTER TABLE [dbo].[image_group_version] CHECK CONSTRAINT [FK153j6ek1mlqxkymq038oa5u2q]
GO
ALTER TABLE [dbo].[image_group_version]  WITH CHECK ADD  CONSTRAINT [FK4k09qywl3vje55n1sl7xioo59] FOREIGN KEY([image_group_id])
REFERENCES [dbo].[image_group] ([id])
GO
ALTER TABLE [dbo].[image_group_version] CHECK CONSTRAINT [FK4k09qywl3vje55n1sl7xioo59]
GO
ALTER TABLE [dbo].[image_product]  WITH CHECK ADD  CONSTRAINT [FKh368u2gls9j1r7tbmryd2ecal] FOREIGN KEY([version_color_id])
REFERENCES [dbo].[version_color] ([id])
GO
ALTER TABLE [dbo].[image_product] CHECK CONSTRAINT [FKh368u2gls9j1r7tbmryd2ecal]
GO
ALTER TABLE [dbo].[image_product]  WITH CHECK ADD  CONSTRAINT [FKhgeuttohylv9en118lpkkqsuy] FOREIGN KEY([image_id])
REFERENCES [dbo].[image] ([id])
GO
ALTER TABLE [dbo].[image_product] CHECK CONSTRAINT [FKhgeuttohylv9en118lpkkqsuy]
GO
ALTER TABLE [dbo].[manufacturer_category]  WITH CHECK ADD  CONSTRAINT [FKawavr5icc38fi84uin0vrjihs] FOREIGN KEY([manufacturer_id])
REFERENCES [dbo].[manufacturer] ([id])
GO
ALTER TABLE [dbo].[manufacturer_category] CHECK CONSTRAINT [FKawavr5icc38fi84uin0vrjihs]
GO
ALTER TABLE [dbo].[manufacturer_category]  WITH CHECK ADD  CONSTRAINT [FKmngog31697n13c3ausn2b2qev] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[manufacturer_category] CHECK CONSTRAINT [FKmngog31697n13c3ausn2b2qev]
GO
ALTER TABLE [dbo].[member_address]  WITH CHECK ADD  CONSTRAINT [FKeslc8586cwl3ej73mv7gr83x2] FOREIGN KEY([member_id])
REFERENCES [dbo].[member] ([id])
GO
ALTER TABLE [dbo].[member_address] CHECK CONSTRAINT [FKeslc8586cwl3ej73mv7gr83x2]
GO
ALTER TABLE [dbo].[member_address]  WITH CHECK ADD  CONSTRAINT [FKqj2crn1egwpc7ibwfqwyoc4de] FOREIGN KEY([ward_id])
REFERENCES [dbo].[ward] ([id])
GO
ALTER TABLE [dbo].[member_address] CHECK CONSTRAINT [FKqj2crn1egwpc7ibwfqwyoc4de]
GO
ALTER TABLE [dbo].[member_order]  WITH CHECK ADD  CONSTRAINT [FK1wqokvx3p0uffyq649fpgn9p9] FOREIGN KEY([branch_id])
REFERENCES [dbo].[branch] ([id])
GO
ALTER TABLE [dbo].[member_order] CHECK CONSTRAINT [FK1wqokvx3p0uffyq649fpgn9p9]
GO
ALTER TABLE [dbo].[member_order]  WITH CHECK ADD  CONSTRAINT [FKl115hxl0wdlo9u4cql0limptd] FOREIGN KEY([member_id])
REFERENCES [dbo].[member] ([id])
GO
ALTER TABLE [dbo].[member_order] CHECK CONSTRAINT [FKl115hxl0wdlo9u4cql0limptd]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [FKckbc6p0fdjoo29f9cuvkv83gt] FOREIGN KEY([member_order_id])
REFERENCES [dbo].[member_order] ([id])
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [FKckbc6p0fdjoo29f9cuvkv83gt]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [FKe3bjsi3v0k471p8qdysoeuqaw] FOREIGN KEY([version_color_id])
REFERENCES [dbo].[version_color] ([id])
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [FKe3bjsi3v0k471p8qdysoeuqaw]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK1mtsbur82frn64de7balymq9s] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK1mtsbur82frn64de7balymq9s]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK89igr5j06uw5ps04djxgom0l1] FOREIGN KEY([manufacturer_id])
REFERENCES [dbo].[manufacturer] ([id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK89igr5j06uw5ps04djxgom0l1]
GO
ALTER TABLE [dbo].[promotion]  WITH CHECK ADD  CONSTRAINT [FKr96oblhcfw8dnkl43knbfipb9] FOREIGN KEY([version_color_id])
REFERENCES [dbo].[version_color] ([id])
GO
ALTER TABLE [dbo].[promotion] CHECK CONSTRAINT [FKr96oblhcfw8dnkl43knbfipb9]
GO
ALTER TABLE [dbo].[promotion_branch]  WITH CHECK ADD  CONSTRAINT [FKbceqv0k609c96g39w0ayffdgv] FOREIGN KEY([promotion_id])
REFERENCES [dbo].[promotion] ([id])
GO
ALTER TABLE [dbo].[promotion_branch] CHECK CONSTRAINT [FKbceqv0k609c96g39w0ayffdgv]
GO
ALTER TABLE [dbo].[promotion_branch]  WITH CHECK ADD  CONSTRAINT [FKqo6sdeardb5pbag28uq4ok1b2] FOREIGN KEY([branch_id])
REFERENCES [dbo].[branch] ([id])
GO
ALTER TABLE [dbo].[promotion_branch] CHECK CONSTRAINT [FKqo6sdeardb5pbag28uq4ok1b2]
GO
ALTER TABLE [dbo].[promotion_province]  WITH CHECK ADD  CONSTRAINT [FKfh0wuny4hq5op64iv9y4o1mhi] FOREIGN KEY([promotion_id])
REFERENCES [dbo].[promotion] ([id])
GO
ALTER TABLE [dbo].[promotion_province] CHECK CONSTRAINT [FKfh0wuny4hq5op64iv9y4o1mhi]
GO
ALTER TABLE [dbo].[promotion_province]  WITH CHECK ADD  CONSTRAINT [FKpjs7m59v2xjpeda2aa7rib9fo] FOREIGN KEY([province_id])
REFERENCES [dbo].[province] ([id])
GO
ALTER TABLE [dbo].[promotion_province] CHECK CONSTRAINT [FKpjs7m59v2xjpeda2aa7rib9fo]
GO
ALTER TABLE [dbo].[promotion_verion_color]  WITH CHECK ADD  CONSTRAINT [FK8gwsmul4pgamubow1g3us9wj5] FOREIGN KEY([version_color_id])
REFERENCES [dbo].[version_color] ([id])
GO
ALTER TABLE [dbo].[promotion_verion_color] CHECK CONSTRAINT [FK8gwsmul4pgamubow1g3us9wj5]
GO
ALTER TABLE [dbo].[promotion_verion_color]  WITH CHECK ADD  CONSTRAINT [FKoqpl8gdn3ce8ie3gw9lg6x9kv] FOREIGN KEY([promotion_id])
REFERENCES [dbo].[promotion] ([id])
GO
ALTER TABLE [dbo].[promotion_verion_color] CHECK CONSTRAINT [FKoqpl8gdn3ce8ie3gw9lg6x9kv]
GO
ALTER TABLE [dbo].[specification]  WITH CHECK ADD  CONSTRAINT [FKbepjo2ilkijj5yto1jjmiavda] FOREIGN KEY([image_id])
REFERENCES [dbo].[image] ([id])
GO
ALTER TABLE [dbo].[specification] CHECK CONSTRAINT [FKbepjo2ilkijj5yto1jjmiavda]
GO
ALTER TABLE [dbo].[specification]  WITH CHECK ADD  CONSTRAINT [FKro70nfh3uafkqm5acrwf4aplu] FOREIGN KEY([version_id])
REFERENCES [dbo].[version] ([id])
GO
ALTER TABLE [dbo].[specification] CHECK CONSTRAINT [FKro70nfh3uafkqm5acrwf4aplu]
GO
ALTER TABLE [dbo].[specification_detail]  WITH CHECK ADD  CONSTRAINT [FKby8pxlfjd338w8ko3hb93wh9n] FOREIGN KEY([specification_id])
REFERENCES [dbo].[specification] ([id])
GO
ALTER TABLE [dbo].[specification_detail] CHECK CONSTRAINT [FKby8pxlfjd338w8ko3hb93wh9n]
GO
ALTER TABLE [dbo].[specification_detail]  WITH CHECK ADD  CONSTRAINT [FKdsumlorpewis1kcxa934fjlv8] FOREIGN KEY([specification_group_id])
REFERENCES [dbo].[specification_group] ([id])
GO
ALTER TABLE [dbo].[specification_detail] CHECK CONSTRAINT [FKdsumlorpewis1kcxa934fjlv8]
GO
ALTER TABLE [dbo].[specification_group]  WITH CHECK ADD  CONSTRAINT [FK1wrtb4n2y255hdtqj3v742lw1] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[specification_group] CHECK CONSTRAINT [FK1wrtb4n2y255hdtqj3v742lw1]
GO
ALTER TABLE [dbo].[transaction_branch]  WITH CHECK ADD  CONSTRAINT [FK6nlfsappwud781l1cx4dtf6wu] FOREIGN KEY([branch_id])
REFERENCES [dbo].[branch] ([id])
GO
ALTER TABLE [dbo].[transaction_branch] CHECK CONSTRAINT [FK6nlfsappwud781l1cx4dtf6wu]
GO
ALTER TABLE [dbo].[transaction_branch]  WITH CHECK ADD  CONSTRAINT [FKpai8jxqn7wjux0nmgb1iahk6w] FOREIGN KEY([transaciton_id])
REFERENCES [dbo].[transactions] ([id])
GO
ALTER TABLE [dbo].[transaction_branch] CHECK CONSTRAINT [FKpai8jxqn7wjux0nmgb1iahk6w]
GO
ALTER TABLE [dbo].[transaction_detail]  WITH CHECK ADD  CONSTRAINT [FK76cffxf8uutrhnh0ogge65q46] FOREIGN KEY([version_color_id])
REFERENCES [dbo].[version_color] ([id])
GO
ALTER TABLE [dbo].[transaction_detail] CHECK CONSTRAINT [FK76cffxf8uutrhnh0ogge65q46]
GO
ALTER TABLE [dbo].[transaction_detail]  WITH CHECK ADD  CONSTRAINT [FKphnbb07qp1446cmoj28w7r3el] FOREIGN KEY([transaction_id])
REFERENCES [dbo].[transactions] ([id])
GO
ALTER TABLE [dbo].[transaction_detail] CHECK CONSTRAINT [FKphnbb07qp1446cmoj28w7r3el]
GO
ALTER TABLE [dbo].[version]  WITH CHECK ADD  CONSTRAINT [FKfaqde0vqat92q6d6novrjif69] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[version] CHECK CONSTRAINT [FKfaqde0vqat92q6d6novrjif69]
GO
ALTER TABLE [dbo].[version_color]  WITH CHECK ADD  CONSTRAINT [FKceuhqryrho30upm5jfn74bwr7] FOREIGN KEY([color_id])
REFERENCES [dbo].[color] ([id])
GO
ALTER TABLE [dbo].[version_color] CHECK CONSTRAINT [FKceuhqryrho30upm5jfn74bwr7]
GO
ALTER TABLE [dbo].[version_color]  WITH CHECK ADD  CONSTRAINT [FKk35wvuclk1t7ox1i7neo337dm] FOREIGN KEY([version_id])
REFERENCES [dbo].[version] ([id])
GO
ALTER TABLE [dbo].[version_color] CHECK CONSTRAINT [FKk35wvuclk1t7ox1i7neo337dm]
GO
ALTER TABLE [dbo].[ward]  WITH CHECK ADD  CONSTRAINT [FKslko72wj5nauqvsgefqkvwpsb] FOREIGN KEY([district_id])
REFERENCES [dbo].[district] ([id])
GO
ALTER TABLE [dbo].[ward] CHECK CONSTRAINT [FKslko72wj5nauqvsgefqkvwpsb]
GO
USE [master]
GO
ALTER DATABASE [tgdd] SET  READ_WRITE 
GO
